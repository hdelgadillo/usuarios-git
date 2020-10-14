/*package com.sysview.docauto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.model.Componente;
import com.sysview.docauto.service.ComponenteService;

@Controller
@RequestMapping("/cmps")
public class ComponenteController {
    
    private static final Logger log = LoggerFactory.getLogger(ComponenteController.class);
	
	@Autowired ComponenteService componenteService;
	
	@RequestMapping(value = "/comcon",
		method = RequestMethod.POST,
		headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Componente>> componentesel(@RequestBody Componente componente){
		List<Componente> componentes = componenteService.filterByComponente(componente);
		  log.debug("plataforma: {}", componente.getPlataformaID());
	      log.debug("sistema: {}", componente.getSistemaID());
	      log.debug("biblioteca: {}", componente.getBibliotecaId());
	      log.debug("clase: {}", componente.getClaseId());
		return new ResponseEntity<List<Componente>>(componentes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/filtro", method = RequestMethod.GET)
	public String cmpfiltro(@ModelAttribute("componente") Componente componente, @ModelAttribute("component") String component,Model model, HttpServletRequest request) {
		List <Componente> lcmp= componenteService.cmpfiltro(componente);
		List <Componente> ulcmp= componenteService.uncmp(component);
		model.addAttribute("componentes",lcmp);
		model.addAttribute("component",ulcmp);
		String username=""; 
        if(request.getUserPrincipal() != null) {
            username = request.getUserPrincipal().getName();
            System.out.println("loginName : " + username );
        }

        model.addAttribute("username", username);
		return "listacomp";
	}
	
	//Un solo componente
	/*@RequestMapping(value="/unfiltro", method = RequestMethod.GET)
	public String cmpsolo(@ModelAttribute("component") String componente, Model model) {
		List <Componente> ulcmp= componenteService.uncmp(componente);
		model.addAttribute("componentes",ulcmp);
		return "listacomp";
	}*/
	/*
	@RequestMapping(value="/detalle/{componente}", method = RequestMethod.GET)
	public String cmpdetalle(Model model, @PathVariable String componente, HttpServletRequest request) {
		Componente unico = componenteService.cmpunico(componente);
		List <Componente> detalle= componenteService.cmpdetalle(componente);
		model.addAttribute("unico",unico);
		model.addAttribute("detalle",detalle);
		String username=""; 
        if(request.getUserPrincipal() != null) {
            username = request.getUserPrincipal().getName();
            System.out.println("loginName : " + username );
        }

        model.addAttribute("username", username);
		return "uncomp";
	}
	
	@RequestMapping(value = "/preview.pdf", method = RequestMethod.GET)
	protected String preivewSection(      
	    HttpServletRequest request,
	        HttpSession httpSession,
	    HttpServletResponse response) {
	    try {
	        byte[] documentInBytes = componenteService.prueba(null).getDocto();         
	        response.setHeader("Content-Disposition", "inline; filename=\"report.xls\"");
	        response.setDateHeader("Expires", -1);
	        response.setContentType("application/vnd.ms-excel");
	        response.setContentLength(documentInBytes.length);
	        response.getOutputStream().write(documentInBytes);
	    } catch (Exception ioe) {
	    //System.out.println("Hey aqui estoy");
	    } finally {
	    }
	    return null;
	}

	@RequestMapping(value = "/detalle/{plataforma}/{sistema}/{clase}/{biblioteca}/{componente}/{producto}/{formato}", method = RequestMethod.GET)
	protected String vistaprevia(      
	    HttpServletRequest request,
	        HttpSession httpSession,
	    HttpServletResponse response,
	    @PathVariable String componente,
	    @PathVariable String plataforma,
	    @PathVariable String sistema,
	    @PathVariable String clase,
	    @PathVariable String biblioteca,
	    @PathVariable String formato,
	    @PathVariable String producto
	    ) {
		Componente comp = new Componente();
		comp.setBibliotecaId(biblioteca);
		comp.setClaseId(clase);
		comp.setComponente(componente);
		comp.setFormatoId(formato);
		comp.setPlataformaID(plataforma);
		comp.setProductoId(producto);
		comp.setSistemaID(sistema);
		String ContentType = null;
		if(formato.equalsIgnoreCase("xls")){
			ContentType="application/vnd.ms-excel";
		}else if(formato.equalsIgnoreCase("pdf")){
			ContentType="application/PDF";
		}else if(formato.equalsIgnoreCase("xlsx")){
			ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}else if(formato.equalsIgnoreCase("txt")){
			ContentType="text/plain";
		}else{
			return null;
		}
		
	    try {
	        byte[] documentInBytes = componenteService.vistaprevia(comp).getDocto();         
	        response.setHeader("Content-Disposition", "inline; filename=\"report."+(formato.equals(".")?".txt":formato)+"\"");
	        response.setDateHeader("Expires", -1);
	        response.setContentType(ContentType);
	        response.setContentLength(documentInBytes.length);
	        response.getOutputStream().write(documentInBytes);
	    } catch (Exception ioe) {
	    
	    	System.out.println("Hey aqui estoy");
	    } finally {
	    }
	    return null;
	}
}
*/