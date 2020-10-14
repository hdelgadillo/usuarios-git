package com.sysview.docauto.controller;

import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.sysview.docauto.service.PlataformaService;
import com.sysview.docauto.service.UsuarioService;
//import com.sysview.docauto.service.UsuarioService;

@Controller
public class LoginController {
	
	//User logueado
	/*  @RequestMapping(value="/login", method = RequestMethod.GET)
	  public String printWelcome(ModelMap model, Principal principal ) {
	 
	      String name = principal.getName(); //get logged in username
	      model.addAttribute("username", name);
	      return "login";
	  }
}*/
//PONER USUARIO LOGUEADO
/*@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {

		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();*/
	
		/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		
		//String name = principal.getName();
		model.addAttribute("username", name);
		return "login";

	}

	@RequestMapping(method = RequestMethod.GET)   
	public ModelAndView showResults(final HttpServletRequest request, Principal principal) {

    final String currentUser = principal.getName();
	return null;

	}*/
	
	@Autowired
    //private UsuarioService usuarioservice;
    
    @RequestMapping("/login")
    public String login() {
//        plataformaService.initialize();
        return "login";
    }

	@RequestMapping("/403")
	public String accessDenied(ModelMap model, Principal principal) {
		  String username = principal.getName();
		  model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
		  return "403";
	}
}
//Metodo original
/*@Controller
public class LoginController {
    
    @Autowired
    private PlataformaService plataformaService;
    
    @RequestMapping("/login")
    public String login() {
//        plataformaService.initialize();
        return "login";
    }
}*/
