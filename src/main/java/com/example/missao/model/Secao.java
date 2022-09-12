package com.example.missao.model;

import javax.persistence.*;

@Entity
public class Secao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String zona;
    private String municipio;
    private String polo;

    public Secao(){

    }
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPolo() {
        return polo;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }
}
