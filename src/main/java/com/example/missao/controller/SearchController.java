package com.example.missao.controller;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.repository.MunicipioRepository;
import com.example.missao.repository.PoloRepository;
import com.example.missao.repository.SecaoRepository;
import com.example.missao.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller  @RequestMapping("search")
public class SearchController {
    @Autowired
    private SecaoRepository secaoRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private PoloRepository poloRepository;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        List<Polo> polos = poloRepository.findAll();
        model.addAttribute("polos", polos);
        return "search/home";
    }

    @GetMapping("cidadesPorPolo")
    public String cidadesPorPolo(@RequestParam Long id, Model model){
        Optional<Municipio> optional = municipioRepository.findById(id);
        List<String> todasCidades = municipioRepository.cidadesPorPolo(id);
        model.addAttribute("municipio",  optional.get().getNome());
        model.addAttribute("todasCidades",  todasCidades);
        System.out.println(todasCidades);
        System.out.println(optional.get().getNome());
        return "search/cidadesPorPolo";
    }

}
