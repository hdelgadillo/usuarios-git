package com.sysview.docauto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.UsuarioService;
@SpringBootApplication
@Controller
@RequestMapping("/up")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
			 	 
	 @RequestMapping(value= "/getusr", method = RequestMethod.GET)
	    public String getUsuario(Model model) {
	          List<Usuario>  us = usuarioService.getUsuario();
	          model.addAttribute("UsuarioPropio",us);
	          return "usuariopropio";
	    }
	
    @RequestMapping(value = "/insertUsuario", method = RequestMethod.POST)
    public String insertUsuario(@ModelAttribute("usuario") Usuario user,BindingResult result) {
           usuarioService.insertUsuario(user);
          return "nuevousr";
    }
    
    
    @RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
    public String deleteUsuario(Usuario user,BindingResult result) {
    	 usuarioService.deleteUsuario(user);
         System.out.println("Usuario Eliminado");
         return "deleteusr";
    }    
    
    @RequestMapping(value = "/updateUsuario", method = RequestMethod.POST)
    public String updateUsuario(@ModelAttribute("usuario") Usuario user) {
    	usuarioService.updateUsuario(user);
    	System.out.println("Usuario Actualizado");
        return "updateusr";
    }
    
    
    @RequestMapping(value = "usrses/{usuario}", method = RequestMethod.GET)
	protected String vistausr(      
	    HttpServletRequest request,
	        HttpSession httpSession,
	    HttpServletResponse response,
	    @PathVariable String Usuario) {
		Usuario user = new Usuario();
		user.setUsuario(Usuario);
		return null;
    }       
    

}