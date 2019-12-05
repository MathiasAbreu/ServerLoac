package br.com.loac.server.ServerLoac.service;

import br.com.loac.server.ServerLoac.dao.DadoDao;
import br.com.loac.server.ServerLoac.entitie.Dado;
import br.com.loac.server.ServerLoac.service.comparator.ComparadorPorData;
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

    public List<Dado> buscaEntreDatas(String[] datas) {

        int diaInicial = Integer.parseInt(datas[0]);
        int diaFinal = Integer.parseInt(datas[1]);

        List<Dado> dados = dadoRepository.findAll();
        Collections.sort(dados, new ComparadorPorData());

        List<Dado> retorno = new ArrayList<>();
        for(Dado dado : dados)
            if(dado.getData().get(Calendar.DAY_OF_MONTH) >= diaInicial && dado.getData().get(Calendar.DAY_OF_MONTH) <= diaFinal)
                retorno.add(dado);

        return retorno;
    }
}
