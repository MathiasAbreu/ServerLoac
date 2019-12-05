package br.com.loac.server.ServerLoac.controller;

import br.com.loac.server.ServerLoac.entitie.Dado;
import br.com.loac.server.ServerLoac.service.DadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("buscaDatas/{dataInicio_dataFinal}")
    public ResponseEntity buscaEntreDatas(@RequestParam String dataInicio_dataFinal) {

        return new ResponseEntity(dadoService.buscaEntreDatas(dataInicio_dataFinal.split("_")),HttpStatus.OK);
    }
}
