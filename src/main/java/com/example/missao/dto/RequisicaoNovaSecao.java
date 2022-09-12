package com.example.missao.dto;

import com.example.missao.model.Secao;

public class RequisicaoNovaSecao {
    public Secao toSecao() {
        Secao secao = new Secao();
        secao.setMunicipio("Recife");
        secao.setPolo("Polo 1");
        secao.setZona("254");

        return secao;
    }
}
