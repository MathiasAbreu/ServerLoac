package br.com.loac.server.ServerLoac.service;

import br.com.loac.server.ServerLoac.dao.DadoDao;
import br.com.loac.server.ServerLoac.entitie.Dado;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class DadoService {

    private DadoDao<Dado, Long> dadoRepository;

    public DadoService(DadoDao<Dado, Long> dadoRepository) {

        super();
        this.dadoRepository = dadoRepository;
    }

    public boolean adicionaDado(Dado dado) {

        dado.setData(Calendar.getInstance());

        if(dadoRepository.save(dado).getId() != 0)
            return true;

        return false;
    }

    public List<Dado> buscaDados() {

        return dadoRepository.findAll();
    }
}
