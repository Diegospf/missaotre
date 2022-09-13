package com.example.missao.controller;

import com.example.missao.dto.RequisicaoNovaSecao;
import com.example.missao.dto.TransformCsvRoot;
import com.example.missao.model.Root;
import com.example.missao.model.Secao;
import com.example.missao.repository.RootRepository;
import com.example.missao.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller @RequestMapping("home")
public class HelloController {
    @Autowired
    private SecaoRepository secaoRepository;
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

    @GetMapping("novo")
    public String novo(){
        secaoRepository.save(toSecao());
        return "redirect:/hello";
    }

    @GetMapping("teste")
    public String teste(){
        System.out.println(rootRepository.numerosPolos());
        return "hello";
    }

    public Secao toSecao() {
//        Secao secao = new Secao();
//        secao.setMunicipio("Recife");
//        secao.setPolo("Polo 1");
//        secao.setZona("254");
//
//        return secao;
        return null;
    }

}
