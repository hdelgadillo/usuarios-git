/*package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.PlataformaDAO;
import com.sysview.docauto.dao.SistemaDAO;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.SistemaService;

@Service("sistemaService")
public class SistemaServiceImpl implements SistemaService{
	
	private static final Logger log = LoggerFactory.getLogger(SistemaServiceImpl.class);
    
    @Autowired
    private SistemaDAO sistemaDao;
    @Autowired
    private PlataformaDAO plataformaDao;
    
	@Override
	public List<Sistema> getSistemas() {
		return sistemaDao.getSistemas();
	}
}
*/