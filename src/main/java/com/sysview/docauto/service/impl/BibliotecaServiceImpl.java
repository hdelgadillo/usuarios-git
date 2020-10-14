/*package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.BibliotecaDAO;
import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.service.BibliotecaService;

@Service("bibliotecaService")
public class BibliotecaServiceImpl implements BibliotecaService{

private static final Logger log = LoggerFactory.getLogger(BibliotecaServiceImpl.class);
    
    @Autowired
    private BibliotecaDAO bibliotecaDao;    
    
    @Override
    public List<Biblioteca> getBibliotecas() {
        return bibliotecaDao.getBibliotecas();
    }

}
*/