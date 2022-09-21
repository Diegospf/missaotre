package com.example.missao.controller;

import com.example.missao.dto.requisicao.RequisicaoMunicipio;
import com.example.missao.dto.requisicao.RequisicaoPolo;
import com.example.missao.dto.requisicao.RequisicaoSecao;
import com.example.missao.dto.requisicao.RequisicaoZona;
import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Secao;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

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

    //POLO
    @GetMapping("polo")
    public String polo(@Valid RequisicaoPolo requisicao, Model model){
        List<Polo> polos = poloRepository.poloOrdenada();
        model.addAttribute("polos", polos);
        return "search/polo";
    }

    @GetMapping("polo/poloSrc")
    public String cidadesPorPolo(@Valid RequisicaoPolo requisicao, @RequestParam String numeroPolo,@RequestParam String tipoDaPesquisa, BindingResult result, Model model){
        List<Municipio> todasCidades = municipioRepository.cidadesPorPolo(Long.parseLong(numeroPolo));
        List<Zona> todasZonas = zonaRepository.zonaPorPolo(Long.parseLong(numeroPolo));
        Long qntSecoesPorPolo = secaoRepository.qntSecoesPorPolo(Long.parseLong(numeroPolo));
        Polo polo = poloRepository.findPolo(Long.parseLong(numeroPolo));
        model.addAttribute("todasCidades",  todasCidades);
        model.addAttribute("todasZonas",  todasZonas);
        model.addAttribute("qntSecoesPorPolo",  qntSecoesPorPolo);
        model.addAttribute("idPolo", numeroPolo);
        model.addAttribute("polo",polo);
        if(requisicao.getTipoDaPesquisa().equals("todos")){
            return "search/polo/todosByPolo";
        }
        else if(requisicao.getTipoDaPesquisa().equals("zona")){
            return "search/polo/zonaByPolo";
        }
        else if(requisicao.getTipoDaPesquisa().equals("municipio")){
            return "search/polo/municipioByPolo";
        }else if(requisicao.getTipoDaPesquisa().equals("secao")){
            return "search/polo/secaoByPolo";
        }else if(requisicao.getTipoDaPesquisa().equals("sede")){
            return "search/polo/sedeByPolo";
        }else{
            return "redirect:/home";
        }
    }

    //MUNICIPIO
    @GetMapping("municipio")
    public  String municipio(@Valid RequisicaoMunicipio requisicao, Model model){
        List<Municipio> municipios = municipioRepository.cidadeOrdenada();
        model.addAttribute("municipios", municipios);
        return "search/municipio";
    }

    @GetMapping("municipio/municipioSrc")
    public  String municipioSrc(@Valid RequisicaoMunicipio requisicao, Model model){
        Long codTse = requisicao.getCodTse();
        Municipio m = municipioRepository.findCidade(codTse);
        model.addAttribute("municipio", m);
        model.addAttribute("codTse",  codTse);
        if(requisicao.getTipoDaPesquisa().equals("todos")){
            List<Secao> secoesPorMunicipio = secaoRepository.secoesPorMunicipio(requisicao.getCodTse());
            model.addAttribute("secoesPorMunicipio",  secoesPorMunicipio);
            return "search/municipio/todosByMunicipio";
        }
        else if(requisicao.getTipoDaPesquisa().equals("zona")){
            List<Zona> zonasPorMunicipio = zonaRepository.zonaPorMunicipio(requisicao.getCodTse());
            model.addAttribute("zonasPorMunicipio",  zonasPorMunicipio);
            return "search/municipio/zonaByMunicipio";
        } else if(requisicao.getTipoDaPesquisa().equals("secao")){
            Long qntSecoesMunicipio = secaoRepository.qntSecoesPorMunicipio(requisicao.getCodTse());
            model.addAttribute("qntSecoesMunicipio",  qntSecoesMunicipio);
            List<Secao> secoesPorMunicipio = secaoRepository.secoesPorMunicipio(requisicao.getCodTse());
            model.addAttribute("secoesPorMunicipio",  secoesPorMunicipio);
            return "search/municipio/secaoByMunicipio";
        }else{
            return "redirect:/home";
        }
    }
    //ZONA
    @GetMapping("zona")
    public  String zona(@Valid RequisicaoZona requisicao, Model model){
        List<Zona> zonas = zonaRepository.zonaOrdenada();
        model.addAttribute("zonas", zonas);
        return "search/zona";
    }

    @GetMapping("zona/zonaSrc")
    public  String zonaSrc(@Valid RequisicaoZona requisicao, Model model){
        Long numero = requisicao.getNumeroZona();
        Zona z = zonaRepository.findZona(numero);
        model.addAttribute("zona", z);

        if(requisicao.getTipoDaPesquisa().equals("todos")){

            Long total = Long.valueOf(0);
            for (Municipio m : z.getMunicipios()){
                total += secaoRepository.qntSecoesPorMunicipio(m.getCodTse());
            }
            model.addAttribute("totalQnt", total);

            return "search/zona/todosByZona";
        }
        else if(requisicao.getTipoDaPesquisa().equals("sede")){
            return "search/zona/sedeByZona";
        } else if(requisicao.getTipoDaPesquisa().equals("municipios")){
            return "search/zona/municipioByZona";
        }else if(requisicao.getTipoDaPesquisa().equals("secoes")){
            Long total = Long.valueOf(0);
            for (Municipio m : z.getMunicipios()){
                total += secaoRepository.qntSecoesPorMunicipio(m.getCodTse());
            }
            model.addAttribute("totalQnt", total);

            return "search/zona/secaoByZona";
        } else{
            return "redirect:/home";
        }
    }
    //SEÇÃO
    @GetMapping("secao")
    public  String zona(@Valid RequisicaoSecao requisicao, Model model){
        List<Long> secoes = secaoRepository.numerosSecaoOrdenada();
        model.addAttribute("secoes", secoes);
        return "search/secao";
    }

    @GetMapping("secao/secaoSrc")
    public  String secaoSrc(@Valid RequisicaoSecao requisicao, Model model){
        Long numero = requisicao.getNumeroSecao();
        List<Secao> secoes = secaoRepository.findSecao(numero);
        model.addAttribute("secoes", secoes);
        model.addAttribute("numero", requisicao.getNumeroSecao());

        if(requisicao.getTipoDaPesquisa().equals("todos")){
            return "search/secao/todosBySecao";
        }
        else if(requisicao.getTipoDaPesquisa().equals("zona")){
            secoes = secaoRepository.findSecaoOrderByZona(numero);
            model.addAttribute("secoes", secoes);
            return "search/secao/zonaBySecao";
        } else if(requisicao.getTipoDaPesquisa().equals("polo")){
            return "search/secao/poloBySecao";
        } else{
            return "redirect:/home";
        }
    }

}
