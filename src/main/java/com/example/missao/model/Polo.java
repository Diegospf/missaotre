package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Polo {
    @Id
    private Long numero;
    @OneToMany(mappedBy = "polo")
    private List<Municipio> municipioSede = new ArrayList<>();
    @OneToOne
    private Municipio sede;

    public Municipio getSede() {
        return sede;
    }

    public void setSede(Municipio sede) {
        this.sede = sede;
    }

    public List<Municipio> getMunicipioSede() {
        return municipioSede;
    }

    public void setMunicipioSede(List<Municipio> municipioSede) {
        this.municipioSede = municipioSede;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
