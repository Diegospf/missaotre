package com.example.missao.dto;

import com.example.missao.model.Root;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransformCsvRoot {
    public static List<Root> toRoot() throws IOException {
        List<Root> roots = new ArrayList<>();

        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/dados.csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> eleitorados = csvReader.readAll();

        for (String[] eleitorado : eleitorados){
            Root root = new Root();
            root.setCodMunicipioTse(eleitorado[0]);
            root.setNomMunicipio(eleitorado[1]);
            root.setNumSecao(eleitorado[2]);
            root.setNumZona(eleitorado[3]);
            root.setNumPolo(eleitorado[4]);

            roots.add(root);
        }
        return roots;
    }
}
