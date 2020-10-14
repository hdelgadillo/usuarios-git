package com.sysview.docauto.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.UsuarioService;
@SpringBootApplication
@Controller
@RequestMapping("/")
public class MenuserController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
    public String verpag(){
          return "menuup";
    }

	@RequestMapping(value= "/nuevouser", method = RequestMethod.GET)
	   public String inserta(){
	          return "nuevousr";
	    }
	
	@RequestMapping(value= "/updateuser", method = RequestMethod.GET)
	   public String actual(){
	          return "updateusr";
	    }
	
	@RequestMapping(value = "/insertUsuario", method = RequestMethod.POST)
    public String insertUsuario(@ModelAttribute("usuario") Usuario user,BindingResult result) {
           usuarioService.insertUsuario(user);
          return "nuevousr";
    }
	
	
	@RequestMapping(value= "/getusr", method = RequestMethod.GET)
    public String getUsuario(Model model) {
          List<Usuario>  us = usuarioService.getUsuario();
          model.addAttribute("UsuarioPropio",us);
          return "usuariopropio";
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
	
}