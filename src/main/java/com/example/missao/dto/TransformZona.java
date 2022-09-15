package com.example.missao.dto;

import com.example.missao.model.Municipio;
import com.example.missao.model.Root;
import com.example.missao.model.Zona;

import java.util.List;

public class TransformZona {
    private List<Root> listaRoot;

    public TransformZona(List<Root> listaRoot) {
        this.listaRoot = listaRoot;
    }

    public void genereteZona(){
        for (Root root : listaRoot){
            if(TransformCsvRoot.zonasTable.get(root.getNumZona()) == null){
                Zona zona = new Zona();
                zona.setNumero(Long.valueOf(root.getNumZona()));
                TransformCsvRoot.zonasTable.put(Long.valueOf(root.getNumZona()), zona);
            }
        }
    }

    public static void update(){
        for(Municipio municipio : TransformCsvRoot.municipiosTable.values()){
            for(Zona zona : municipio.getZonas()){
                if(municipio.getZonas().contains(zona)){
                    if(!zona.getMunicipios().contains(municipio)){
                        zona.getMunicipios().add(municipio);
                    }
                }
            }
        }
    }
}
