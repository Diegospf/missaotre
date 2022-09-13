package com.example.missao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Root {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codMunicipioTse;
    private String nomMunicipio;
    private String numSecao;
    private String numZona;
    private String numPolo;

    public Root(){

    }
    public String getCodMunicipioTse() {
        return codMunicipioTse;
    }

    public void setCodMunicipioTse(String codMunicipioTse) {
        this.codMunicipioTse = codMunicipioTse;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public String getNumSecao() {
        return numSecao;
    }

    public void setNumSecao(String numSecao) {
        this.numSecao = numSecao;
    }

    public String getNumZona() {
        return numZona;
    }

    public void setNumZona(String numZona) {
        this.numZona = numZona;
    }

    public String getNumPolo() {
        return numPolo;
    }

    public void setNumPolo(String numPolo) {
        this.numPolo = numPolo;
    }
}
