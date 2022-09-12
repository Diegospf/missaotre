package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Municipio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTse;
    private String nome;
    private ArrayList<String> zonas;
    private ArrayList<String> polo;
}
