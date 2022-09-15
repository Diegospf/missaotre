package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Municipio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long codTse;
    private String nome;
    @ManyToMany(mappedBy = "municipios")
    private List<Zona> zonas = new ArrayList<>();
    @OneToMany(mappedBy = "municipio")
    private List<Secao> secoes = new ArrayList<>();
    @ManyToOne
    private Polo polo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodTse() {
        return codTse;
    }

    public void setCodTse(Long codTse) {
        this.codTse = codTse;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }

    public Polo getPolo() {
        return polo;
    }

    public void setPolo(Polo polo) {
        this.polo = polo;
    }
}
