package com.example.missao.dto;

import com.example.missao.model.Polo;
import com.example.missao.model.Root;

import java.util.List;

public class TransformPolo  {
    private List<Root> listaRoot;

    public TransformPolo(List<Root> listaRoot) {
        this.listaRoot = listaRoot;
    }

    public void generatePoloTable(){
        for (Root root : listaRoot){
            if(TransformCsvRoot.polosTable.get(root.getNumPolo()) == null){
                Polo polo = new Polo();
                polo.setNumero(Long.valueOf(root.getNumPolo()));
                TransformCsvRoot.polosTable.put(Long.valueOf(root.getNumPolo()), polo);
            }
        }
    }
}
