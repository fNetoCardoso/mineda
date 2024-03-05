package br.gov.sp.fatec.projetospring20231.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.projetospring20231.entity.Anotacao;
import br.gov.sp.fatec.projetospring20231.entity.Usuario;
import br.gov.sp.fatec.projetospring20231.repository.AnotacaoRepository;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepo;

    @Autowired
    private UsuarioService usuarioService;

    public Anotacao nova(Anotacao anotacao) {
        if(anotacao == null ||
                anotacao.getTexto() == null ||
                anotacao.getTexto().isBlank() ||
                anotacao.getUsuario() == null ||
                anotacao.getUsuario().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(anotacao.getDataHora() == null) {
            anotacao.setDataHora(LocalDateTime.now());
        }
        Usuario usuario = usuarioService
            .buscaUsuarioPorId(anotacao.getUsuario().getId());
        anotacao.setUsuario(usuario);
        return anotacaoRepo.save(anotacao);
    }

    public List<Anotacao> buscarTodas() {
        return anotacaoRepo.findAll();
    }
    
}