package br.com.loac.server.ServerLoac.entitie;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Dado {

    @Id @GeneratedValue
    private Long id;

    private Double distancia;

    private Calendar data;

    @JsonCreator
    public Dado(Long id, double distancia) {

        super();
        this.id = id;
        this.distancia = distancia;
    }

    @JsonCreator
    public Dado() {

        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
