/*package com.sysview.docauto.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sysview.docauto.dao.FilterDAO;
import com.sysview.docauto.model.Filter;

@Repository("filterDao")
public class filterDAOImpl implements FilterDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Filter> filterBy(Filter filter) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT distinct plataformaId, sistemaId, claseId, bibliotecaId ");
    sql.append("FROM CONSULTA ");
    sql.append("WHERE 1=1 ");
    
    List<String> params = new ArrayList<String>();
    
    if(!StringUtils.isEmpty(filter.getComponenete())) {
        sql.append("AND componente like ? ");
        params.add(filter.getComponenete());
      }
    
    if(!StringUtils.isEmpty(filter.getPlataformaId())) {
      sql.append("AND plataformaId = ? ");
      params.add(filter.getPlataformaId());
    }

    if(!StringUtils.isEmpty(filter.getSistemaId())) {
      sql.append("AND sistemaId = ? ");
      params.add(filter.getSistemaId());
    }

    if(!StringUtils.isEmpty(filter.getClaseId())) {
      sql.append("AND claseId = ? ");
      params.add(filter.getClaseId());
    }
    
    if(!StringUtils.isEmpty(filter.getBibliotecaId())) {
      sql.append("AND bibliotecaId = ? ");
      params.add(filter.getBibliotecaId());
    }
    
    return jdbcTemplate.query(sql.toString(), params.toArray(),
        BeanPropertyRowMapper.newInstance(Filter.class));
  }
}*/
