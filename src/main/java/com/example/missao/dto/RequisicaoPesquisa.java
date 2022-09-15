package com.example.missao.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RequisicaoPesquisa {
    @NotBlank @NotEmpty
    private String choiced;

    public String getChoiced() {
        return choiced;
    }

    public void setChoiced(String choiced) {
        this.choiced = choiced;
    }
}
