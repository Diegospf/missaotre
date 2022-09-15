package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zona {
    @Id
    private Long id;

    private Long numero;
    @ManyToMany
    private List<Municipio> municipios = new ArrayList<>();

    public void setId() {
        this.id = numero;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
        setId();
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
}
