package com.example.missao.dto.transform;

import com.example.missao.model.Root;
import com.example.missao.model.Zona;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static void update(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> municipiosSedeZona = csvReader.readAll();

        List<Zona> zonas = new ArrayList<>();

        for (String[] z : municipiosSedeZona){
            Zona zona = TransformCsvRoot.zonasTable.get(Long.parseLong(z[0]));
            zona.setSede(TransformCsvRoot.municipiosTable.get(Long.parseLong(z[1])));
            zonas.add(zona);
        }
    }
}
