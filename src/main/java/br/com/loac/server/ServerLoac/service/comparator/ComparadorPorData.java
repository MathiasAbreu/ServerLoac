package br.com.loac.server.ServerLoac.service.comparator;

import br.com.loac.server.ServerLoac.entitie.Dado;

import java.util.Comparator;

public class ComparadorPorData implements Comparator<Dado> {

    @Override
    public int compare(Dado dado01, Dado dado02) {
        return dado01.getData().compareTo(dado02.getData());
    }
}
