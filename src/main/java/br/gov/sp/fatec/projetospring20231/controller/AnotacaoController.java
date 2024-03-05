package br.gov.sp.fatec.projetospring20231.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projetospring20231.entity.Anotacao;
import br.gov.sp.fatec.projetospring20231.service.AnotacaoService;

@RestController
@RequestMapping(value = "/anotacao")
@CrossOrigin
public class AnotacaoController {
    
    @Autowired
    private AnotacaoService service;

    @GetMapping
    public List<Anotacao> buscarTodasAnotacoes() {
        return service.buscarTodas();
    }

    @PostMapping
    public Anotacao cadastrarNovaAnotacao(@RequestBody Anotacao anotacao) {
        return service.nova(anotacao);
    }

}