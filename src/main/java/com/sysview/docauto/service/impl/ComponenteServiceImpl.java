/*package com.sysview.docauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.ComponenteDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.service.ComponenteService;


@Service ("componenteService")
public class ComponenteServiceImpl implements ComponenteService{

	@Autowired 
	private ComponenteDAO componenteDao;
	
	@Override
	public List<Componente> filterByComponente(Componente componente) {
	    return componenteDao.findcomponente(componente);
	}

	@Override
	public List<Componente> cmpfiltro(Componente componente) {
		return componenteDao.resultcomp(componente);
	}
	
	@Override
	public Componente cmpunico(String componente) {
		return componenteDao.resultunico(componente);
	}

	@Override
	public List<Componente> cmpdetalle(String componente) {
		return componenteDao.resultdetalle(componente);
	}
	
	@Override
	public Componente prueba(String componente) {
		return componenteDao.prueba(componente);
	}

	@Override
	public Componente vistaprevia(Componente componente) {
		return componenteDao.vistaprevia(componente);
	}
	
	@Override
	public List<Componente> uncmp(String componente) {
		return componenteDao.cmpsolo(componente);
	}

}*/
