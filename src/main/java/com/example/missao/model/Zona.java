package com.example.missao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
@Entity
public class Zona {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String municipio;
    private ArrayList<String> municipios;
}
