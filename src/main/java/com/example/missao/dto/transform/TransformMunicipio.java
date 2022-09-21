package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Root;
import com.example.missao.model.Secao;
import com.example.missao.model.Zona;

import java.util.List;

public class TransformMunicipio {

    private static List<Root> listaRoot;

    public TransformMunicipio(List<Root> listaRoot) {
        this.listaRoot = listaRoot;
    }

    public void generateMunicipio(Long codTse, String nomeMunicipio, Long numPolo, Long numZona){
        Municipio municipio = new Municipio();
        municipio.setCodTse(codTse);
        municipio.setNome(nomeMunicipio);
        municipio.setPolo(TransformCsvRoot.polosTable.get(numPolo));
//        List<Zona> zona = municipio.getZonas();
//        if(!zona.contains(TransformCsvRoot.zonasTable.get(numZona))){
//            municipio.getZonas().add(TransformCsvRoot.zonasTable.get(numZona));
//        }
        TransformCsvRoot.municipiosTable.put(codTse, municipio);
    }

    public void addSecaoInMunicipio(Long codTse, List<Secao> secoes){
        TransformCsvRoot.municipiosTable.get(codTse).setSecoes(secoes);
    }

    public static void update(){
        for (Municipio m : TransformCsvRoot.municipiosTable.values()){
            for (Root root : listaRoot){
                if(Long.parseLong(root.getCodMunicipioTse()) == m.getCodTse()){
                    for (Zona z : TransformCsvRoot.zonasTable.values()){
                        if (Long.parseLong(root.getNumZona()) == z.getNumero()){
                            if (!(z.getMunicipios().contains(m)) && !(m.getZonas().contains(z))){
                                m.getZonas().add(z);
                                z.getMunicipios().add(m);
                            }
                        }
                    }
                }
            }
        }
    }
}
