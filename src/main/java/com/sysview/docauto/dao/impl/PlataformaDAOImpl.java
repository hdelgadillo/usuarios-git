/*package com.sysview.docauto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sysview.docauto.dao.PlataformaDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.model.Sistema;

@Component("plataformaDao")
public class PlataformaDAOImpl implements PlataformaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger log = LoggerFactory.getLogger(PlataformaDAOImpl.class);
    
    @Override
    public List<Plataforma> getPlataformas() {
        log.debug("consultando plataformas...");
        
        List<Plataforma> plataformas = jdbcTemplate.query(
        "select * from plataforma",
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataforma = new Plataforma(rs.getString(1));
                return plataforma;
            }
        });
        log.debug("plataformas: {}", plataformas.toString());
        return plataformas;
    }
    
    @Override
    public List<Plataforma> filterBySistemas(String sistemaId) {	
    	
    	log.debug("consultando Plataformas en base al sistema...");
        
        List<Plataforma> plataformaps = jdbcTemplate.query(
        "select distinct PLATAFORMAID from CONSULTA where SISTEMAID=?",
        new Object[]{sistemaId},
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataformap = new Plataforma(rs.getString(1));
                return plataformap;
            }
        });
        log.debug("sistemas: {}", plataformaps.toString());
        return plataformaps;
    }
    
    @Override
    public List<Plataforma> filterByClase(String claseId) {	
    	
    	log.debug("consultando Plataformas en base a la clase...");
        
        List<Plataforma> plataformapc = jdbcTemplate.query(
        "select distinct PLATAFORMAID from CONSULTA where CLASEID=?",
        new Object[]{claseId},
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataformac = new Plataforma(rs.getString(1));
                return plataformac;
            }
        });
        log.debug("sistemas: {}", plataformapc.toString());
        return plataformapc;
    }
    
    @Override
    public List<Plataforma> filterByBiblioteca(String bibliotecaId) {	
    	
    	log.debug("consultando Plataformas en base a la biblioteca...");
        
        List<Plataforma> plataformapb = jdbcTemplate.query(
        "select distinct PLATAFORMAID from CONSULTA where BIBLIOTECAID=?",
        new Object[]{bibliotecaId},
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataformab = new Plataforma(rs.getString(1));
                return plataformab;
            }
        });
        log.debug("sistemas: {}", plataformapb.toString());
        return plataformapb;
    }
}*/

