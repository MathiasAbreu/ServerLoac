package br.com.loac.server.ServerLoac.dao;

import br.com.loac.server.ServerLoac.entitie.Dado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DadoDao<T, ID extends Serializable> extends JpaRepository<Dado, Long> {
}
