package com.example.missao.dto.transform;

import com.example.missao.model.*;

import java.util.ArrayList;
import java.util.List;

public class TransformSecao {
    private List<Root> listaRoot;

    public TransformSecao(List<Root> listaRoot) {
        this.listaRoot = listaRoot;
    }

    public List<Secao> generateSecaoTable(){
        List<Secao> secaoTable = new ArrayList<>();

        TransformMunicipio transformMunicipio = new TransformMunicipio(listaRoot);
        //Zona
        TransformZona transformZona = new TransformZona(listaRoot);
        transformZona.genereteZona();
        //Polo
        TransformPolo transformPolo = new TransformPolo(listaRoot);
        transformPolo.generatePoloTable();

        for (Root root : listaRoot) {
            Long codTse = Long.parseLong(root.getCodMunicipioTse());
            String nomeMunicipio = root.getNomMunicipio();
            Long numPolo = Long.parseLong(root.getNumPolo());
            Long numSecao = Long.parseLong(root.getNumSecao());
            Long numZona = Long.parseLong(root.getNumZona());

            Secao secao = new Secao();

            if(TransformCsvRoot.municipiosTable.get(codTse) == null){
                //criar municipio
                transformMunicipio.generateMunicipio(codTse, nomeMunicipio, numPolo, numZona);
            }
            List<Secao> secoes = TransformCsvRoot.municipiosTable.get(codTse).getSecoes();
            secoes.add(secao);
            transformMunicipio.addSecaoInMunicipio(codTse, secoes);


            secao.setNumero(numSecao);
            secao.setZona(TransformCsvRoot.zonasTable.get(numZona));
            secao.setPolo(TransformCsvRoot.polosTable.get(numPolo));
            secao.setMunicipio(TransformCsvRoot.municipiosTable.get(codTse));
            secaoTable.add(secao);
        }

        return secaoTable;
    }

}
