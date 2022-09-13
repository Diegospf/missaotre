package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Secao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    @ManyToOne
    private Zona zona;
    @ManyToOne
    private Municipio municipio;
    @ManyToOne
    private Polo polo;

    public Secao(){

    }
    //TODO LOMBOK
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
