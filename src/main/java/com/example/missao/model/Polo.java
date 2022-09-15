package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Polo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;
    @OneToMany(mappedBy = "polo")
    private List<Municipio> municipioSede= new ArrayList<>();

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
