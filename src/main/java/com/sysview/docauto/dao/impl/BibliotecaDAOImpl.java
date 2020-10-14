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

import com.sysview.docauto.dao.BibliotecaDAO;
import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Componente;

@Component("bibliotecaDao")
public class BibliotecaDAOImpl implements BibliotecaDAO {
    
    private static final Logger log = LoggerFactory.getLogger(BibliotecaDAOImpl.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Biblioteca> getBibliotecas() {
        log.debug("consultando bibliotecas...");
        
        List<Biblioteca> bibliotecas = jdbcTemplate.query(
        "select BIBLIOTECAID from Biblioteca order by (BIBLIOTECAID)",
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca biblioteca = new Biblioteca(rs.getString(1));
                return biblioteca;
            }
        });
        log.debug("clases: {}", bibliotecas.toString());
        return bibliotecas;
    }

	//Filtrado por clase original
    @Override
	public List<Biblioteca> filterByClase(String claseId) {
		log.debug("consultando Plataformas en base a la clase...");
        
        List<Biblioteca> bibliotecafc = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where CLASEID=?",
        new Object[]{claseId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecafbc = new Biblioteca(rs.getString(1));
                return bibliotecafbc;
            }
        });
        log.debug("sistemas: {}", bibliotecafc.toString());
        return bibliotecafc;
	}
    
   @Override
	public List<Biblioteca> filterByPlataforma(String plataformaId) {
	   log.debug("consultando Plataformas en base a la clase...");
        
        List<Biblioteca> bibliotecafc = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where PlataformaID=?",
        new Object[]{plataformaId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecafbp = new Biblioteca(rs.getString(1));
                return bibliotecafbp;
            }
        });
        log.debug("sistemas: {}", bibliotecafc.toString());
        return bibliotecafc;
	}

	@Override
	public List<Biblioteca> filterBySistema(String plataformaId) {
		List<Biblioteca> bibliotecafc = jdbcTemplate.query(
	        "select distinct BIBLIOTECAID from CONSULTA where SISTEMAID=?",
	        new Object[]{plataformaId},
	        new RowMapper<Biblioteca>() {
	            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Biblioteca bibliotecafbp = new Biblioteca(rs.getString(1));
	                return bibliotecafbp;
	            }
	        });
	        log.debug("sistemas: {}", bibliotecafc.toString());
	        return bibliotecafc;
	}

	@Override
	public List<Biblioteca> filterclasis(String claseId, String sistemaId) {
		List<Biblioteca> bibliotecafc = jdbcTemplate.query(
		        "select distinct BIBLIOTECAID from CONSULTA where CLASEID=? and SISTEMAID=?",
		        new Object[]{claseId,sistemaId},
		        new RowMapper<Biblioteca>() {
		            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Biblioteca bibliotecafbp = new Biblioteca(rs.getString(1));
		                return bibliotecafbp;
		            }
		        });
		        log.debug("sistemas: {}", bibliotecafc.toString());
		        return bibliotecafc;
	}

	@Override
	public List<Biblioteca> filterplacasis(String claseId, String sistemaId, String plataformaId) {
		List<Biblioteca> bibliotecafc = jdbcTemplate.query(
		        "select distinct BIBLIOTECAID from CONSULTA where CLASEID=? and SISTEMAID=? and PLATAFORMAID=?",
		        new Object[]{claseId,sistemaId,plataformaId},
		        new RowMapper<Biblioteca>() {
		            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Biblioteca bibliotecafbp = new Biblioteca(rs.getString(1));
		                return bibliotecafbp;
		            }
		        });
		        log.debug("sistemas: {}", bibliotecafc.toString());
		        return bibliotecafc;
	}
	
}*/