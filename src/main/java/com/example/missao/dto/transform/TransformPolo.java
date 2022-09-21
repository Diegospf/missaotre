package com.example.missao.dto.transform;

import com.example.missao.model.Polo;
import com.example.missao.model.Root;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static void update(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> municipiosSedePolo = csvReader.readAll();

        List<Polo> polos = new ArrayList<>();

        for (String[] p : municipiosSedePolo){
            Polo polo = TransformCsvRoot.polosTable.get(Long.parseLong(p[0]));
            polo.setSede(TransformCsvRoot.municipiosTable.get(Long.parseLong(p[1])));
            System.out.println(p[1]);
            polos.add(polo);
        }
    }
}
