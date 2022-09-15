package com.example.missao.controller;

import com.example.missao.dto.TransformCsvRoot;
import com.example.missao.dto.TransformSecao;
import com.example.missao.dto.TransformZona;
import com.example.missao.model.Municipio;
import com.example.missao.model.Root;
import com.example.missao.model.Secao;
import com.example.missao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Controller @RequestMapping("home")
public class HelloController {
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
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        return "hello";
    }

    @GetMapping("root")
    public String root(Model model) throws IOException {
        List<Root> roots = TransformCsvRoot.toRoot();
        rootRepository.saveAll(roots);
        return "root";
    }

    @GetMapping("preencherTabelas")
    public String preencherTabelas(Model model) throws IOException {
        TransformSecao transformSecao = new TransformSecao(rootRepository.findAll());
        List<Secao> secoes = transformSecao.generateSecaoTable();
        poloRepository.saveAll(TransformCsvRoot.polosTable.values());
        zonaRepository.saveAll(TransformCsvRoot.zonasTable.values());
        municipioRepository.saveAll(TransformCsvRoot.municipiosTable.values());
        TransformZona.update();
        zonaRepository.saveAll(TransformCsvRoot.zonasTable.values());
        secaoRepository.saveAll(secoes);
        return "hello";
    }

    @GetMapping("teste")
    public String teste(Model model){
        List<Long> listTodosPolos = rootRepository.numerosPolos();
        List<String> listCidade = rootRepository.nomesCidades();
        List<String> listCidadePorPolo = rootRepository.cidadesPorPolo("1");
        List<String> listCidadePorSecao = rootRepository.cidadesPorSecao("1");
        String poloDaCidade = rootRepository.poloPorCidade("25313");
        model.addAttribute("list",listTodosPolos);
        model.addAttribute("cidades", listCidade);
        model.addAttribute("cidadesPorPolo", listCidadePorPolo);
        model.addAttribute("cidadesPorSecao", listCidadePorSecao);
        model.addAttribute("poloDaCidade", poloDaCidade);

        Municipio m = new Municipio();


        Collections.sort(listTodosPolos);
        return "teste";
    }

    @GetMapping("createZona")
    public String createZona(Model model){
        return "hello";
    }

}
