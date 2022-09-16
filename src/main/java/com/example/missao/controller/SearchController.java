package com.example.missao.controller;

import com.example.missao.dto.RequisicaoPolo;
import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;
import com.example.missao.repository.MunicipioRepository;
import com.example.missao.repository.PoloRepository;
import com.example.missao.repository.SecaoRepository;
import com.example.missao.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
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
    public String cidadesPorPolo(@Valid RequisicaoPolo requisicao, @RequestParam String numeroPolo,@RequestParam String tipoDaPesquisa, BindingResult result, Model model){
        List<Municipio> todasCidades = municipioRepository.cidadesPorPolo(Long.parseLong(numeroPolo));
        List<Zona> todasZonas = zonaRepository.findAll();
        model.addAttribute("todasCidades",  todasCidades);
        model.addAttribute("todasZonas",  todasZonas);
        model.addAttribute("idPolo", numeroPolo);
        if(requisicao.getTipoDaPesquisa().equals("todos")){
            return "search/todosByPolo";
        }
        else if(requisicao.getTipoDaPesquisa().equals("zona")){
            return "search/zonaByPolo";
        }
        else if(requisicao.getTipoDaPesquisa().equals("municipio")){
            return "search/municipioByPolo";
        }else{
            return "redirect:/home";
        }
    }

    @GetMapping("cidadesPorPolo/todos")
    public String cidadesPorPoloTodos(@Valid RequisicaoPolo requisicao,@RequestParam Long id,@RequestParam String tipo, Model model){
        if(requisicao.getTipoDaPesquisa().equals("todos")){
            return "search/cidadesPorPolo/todos";
        }
        else if(requisicao.getTipoDaPesquisa().equals("zona")){
            return "search/cidadesPorPolo/zona";
        }
        else if(requisicao.getTipoDaPesquisa().equals("municipio")){
            return "search/cidadesPorPolo/municipio";
        }
        return "search/cidadesPorPolo";
    }


    @GetMapping("cidadesPorPolo/zona")
    public String cidadesPorPoloZona(@Valid RequisicaoPolo requisicao, @RequestParam Long id, Model model){
        List<Municipio> todasCidades = municipioRepository.cidadesPorPolo(id);
        model.addAttribute("todasCidades",  todasCidades);
        System.out.println(todasCidades);
        return "search/cidadesPorPolo";
    }


    @GetMapping("cidadesPorPolo/municipio")
    public String cidadesPorPoloMunicipio(@Valid RequisicaoPolo requisicao, @RequestParam Long id, Model model){
        List<Municipio> todasCidades = municipioRepository.cidadesPorPolo(id);
        model.addAttribute("todasCidades",  todasCidades);
        System.out.println(todasCidades);
        return "search/cidadesPorPolo";
    }
    @GetMapping("polo")
    public String polo(@Valid RequisicaoPolo requisicao, Model model){
        List<Polo> polos = poloRepository.findAll();
        model.addAttribute("polos", polos);
        return "search/polo";
    }

}
