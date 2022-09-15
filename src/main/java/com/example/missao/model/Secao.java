package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Secao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;
    @ManyToOne
    private Zona zona;
    @ManyToOne
    private Municipio municipio;
    @ManyToOne
    private Polo polo;

    public Secao(){

    }
    public Long getId() {
        return id;
    }

    //TODO LOMBOK
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Polo getPolo() {
        return polo;
    }

    public void setPolo(Polo polo) {
        this.polo = polo;
    }
}
