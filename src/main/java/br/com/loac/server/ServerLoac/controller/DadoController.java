package br.com.loac.server.ServerLoac.controller;

import br.com.loac.server.ServerLoac.entitie.Dado;
import br.com.loac.server.ServerLoac.service.DadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DadoController {

    private DadoService dadoService;

    public DadoController(DadoService dadoService) {

        super();
        this.dadoService = dadoService;
    }


    @PostMapping("distancia")
    public ResponseEntity adicionaDistancia(@RequestBody Dado dado) {

        if(dadoService.adicionaDado(dado))
            return new ResponseEntity(HttpStatus.CREATED);

        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("distancia")
    public ResponseEntity buscaDados() {

        return new ResponseEntity(dadoService.buscaDados(),HttpStatus.OK);
    }

    @GetMapping("buscaDatas")
    public ResponseEntity buscaEntreDatas(List<String> datas) {

        return new ResponseEntity(dadoService.buscaEntreDatas(datas),HttpStatus.OK);
    }
}
