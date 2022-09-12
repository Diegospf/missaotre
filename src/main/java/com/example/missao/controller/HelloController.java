package com.example.missao.controller;

import com.example.missao.dto.RequisicaoNovaSecao;
import com.example.missao.model.Secao;
import com.example.missao.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller @RequestMapping("home")
public class HelloController {
    @Autowired
    private SecaoRepository secaoRepository;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        return "hello";
    }

    @GetMapping("novo")
    public String novo(){
        secaoRepository.save(toSecao());
        return "redirect:/hello";
    }

    public Secao toSecao() {
        Secao secao = new Secao();
        secao.setMunicipio("Recife");
        secao.setPolo("Polo 1");
        secao.setZona("254");

        return secao;
    }
}
