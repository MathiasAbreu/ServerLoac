package br.com.loac.server.ServerLoac.controller;

import br.com.loac.server.ServerLoac.entitie.Dado;
import br.com.loac.server.ServerLoac.service.DadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadoController {

    private DadoService dadoService;

    public DadoController(DadoService dadoService) {

        super();
        this.dadoService = dadoService;
    }


    @PostMapping("loac/distancia")
    public ResponseEntity adicionaDistancia(@RequestBody Dado dado) {

        if(dadoService.adicionaDado(dado))
            return new ResponseEntity(HttpStatus.CREATED);

        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
