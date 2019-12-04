package br.com.loac.server.ServerLoac.service;

import br.com.loac.server.ServerLoac.dao.DadoDao;
import br.com.loac.server.ServerLoac.entitie.Dado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

    public List<Dado> buscaEntreDatas(List<String> datas) {

        String[] dataInicial = datas.get(0).split("-");
        String[] dataFinal = datas.get(1).split("-");

        int diaInicial = Integer.parseInt(dataInicial[2]);
        int diaFinal = Integer.parseInt(dataFinal[2]);

        List<Dado> dados = dadoRepository.findAll();
        List<Dado> retorno = new ArrayList<>();
        for(Dado dado : dados)
            if(dado.getData().getTime().getDay() >= diaInicial && dado.getData().getTime().getDay() <= diaFinal)
                retorno.add(dado);

        return retorno;
    }
}
