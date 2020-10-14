/*package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.ClaseDAO;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.service.ClaseService;

@Service("claseService")
public class ClaseServiceImpl implements ClaseService {
	
	private static final Logger log = LoggerFactory.getLogger(ClaseServiceImpl.class);
    
    @Autowired
    private ClaseDAO claseDao;
    
    @Override
    public List<Clase> getClases() {
        return claseDao.getClases();
    }

}*/