package com.example.missao.controller;

import com.example.missao.dto.transform.*;
import com.example.missao.model.Municipio;
import com.example.missao.model.Root;
import com.example.missao.model.Secao;
import com.example.missao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private SecaoRepository secaoRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private PoloRepository poloRepository;
    @Autowired
    private RootRepository rootRepository;

//    @GetMapping("root")
//    public String root(Model model) throws IOException {
//        List<Root> roots = TransformCsvRoot.toRoot();
//        rootRepository.saveAll(roots);
//        return "home";
//    }
//
//    @GetMapping("preencherTabelas")
//    public String preencherTabelas(Model model) throws IOException {
//        TransformSecao transformSecao = new TransformSecao(rootRepository.findAll());
//        List<Secao> secoes = transformSecao.generateSecaoTable();
//        poloRepository.saveAll(TransformCsvRoot.polosTable.values());
//        zonaRepository.saveAll(TransformCsvRoot.zonasTable.values());
//        municipioRepository.saveAll(TransformCsvRoot.municipiosTable.values());
//        TransformMunicipio.update();
//        municipioRepository.saveAll(TransformCsvRoot.municipiosTable.values());
//        zonaRepository.saveAll(TransformCsvRoot.zonasTable.values());
//        TransformZona.update("src/main/resources/zonas-sedes.csv");
//        zonaRepository.saveAll(TransformCsvRoot.zonasTable.values());
//        TransformPolo.update("src/main/resources/polos-sedes.csv");
//        poloRepository.saveAll(TransformCsvRoot.polosTable.values());
//        secaoRepository.saveAll(secoes);
//        return "home";
//    }

    @GetMapping("home")
    public String home(Model model){
        return "home";
    }

}
