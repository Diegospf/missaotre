package com.example.missao.model;

import javax.persistence.*;

@Entity
public class Polo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String municipioSede;
}
