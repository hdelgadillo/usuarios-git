/*package com.sysview.docauto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.BibliotecaService;
import com.sysview.docauto.service.ClaseService;
import com.sysview.docauto.service.PlataformaService;
import com.sysview.docauto.service.SistemaService;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private PlataformaService plataformaService;
    @Autowired
    private SistemaService sistemaService;
    @Autowired
    private ClaseService claseService;
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        List<Plataforma> plataformas = plataformaService.getPlataformas();
        List<Sistema> sistemas = sistemaService.getSistemas();
        List<Clase> clases = claseService.getClases();
        List<Biblioteca> bibliotecas = bibliotecaService.getBibliotecas();
        model.addAttribute("plataformas", plataformas);
        model.addAttribute("sistemas", sistemas);
        model.addAttribute("clases", clases);
        model.addAttribute("bibliotecas", bibliotecas);
        String username=""; 
        if(request.getUserPrincipal() != null) {
            username = request.getUserPrincipal().getName();
            System.out.println("loginName : " + username );
        }

        model.addAttribute("username", username);
        return "index";
    }
    
    
    @RequestMapping(value="/menu", method=RequestMethod.GET)
    public String home2(Model model) {
        List<Plataforma> plataformas = plataformaService.getPlataformas();
        List<Sistema> sistemas = sistemaService.getSistemas();
        List<Clase> clases = claseService.getClases();
        List<Biblioteca> bibliotecas = bibliotecaService.getBibliotecas();
        model.addAttribute("plataformas", plataformas);
        model.addAttribute("sistemas", sistemas);
        model.addAttribute("clases", clases);
        model.addAttribute("bibliotecas", bibliotecas);
        return "index";
    }
    
    
    @RequestMapping(value="/in",method=RequestMethod.GET)
    public String getCreateForm(Model model, HttpServletRequest request) {

        String username=""; 
        if(request.getUserPrincipal() != null) {
            username = request.getUserPrincipal().getName();
            System.out.println("loginName : " + username );
        }
        if(request.getUserPrincipal().equals("ADMIN")){
        	username = request.getUserPrincipal().getName();
        	model.addAttribute("username", username);
        	return "index";
        }
        else{
        	username = request.getUserPrincipal().getName();
        	model.addAttribute("username", username);
        	return "indexusr";
        }
    }        
}*/