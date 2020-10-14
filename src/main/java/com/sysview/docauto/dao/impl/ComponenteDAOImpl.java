/*package com.sysview.docauto.dao.impl;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sysview.docauto.dao.ComponenteDAO;
import com.sysview.docauto.model.Componente;
//import com.sysview.docauto.model.Usuario;

@Component ("componenteDao")
public class ComponenteDAOImpl implements ComponenteDAO {
	  
	  private static final Logger log = LoggerFactory.getLogger(ComponenteDAOImpl.class);
	  
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  @Override
	  public List<Componente> findcomponente(Componente componente){
	      log.debug("consultando Componentes...");
	      
	      log.debug("plataforma: {}", componente.getPlataformaID());
	      log.debug("sistema: {}", componente.getSistemaID());
	      log.debug("biblioteca: {}", componente.getBibliotecaId());
	      log.debug("clase: {}", componente.getClaseId());
	      
	      String sql = "SELECT DISTINCT PLATAFORMAID,";
	      sql += " SISTEMAID,";
	      sql += " BIBLIOTECAID,";
	      sql += " CLASEID,";
	      sql += " COMPONENTE,";
          sql += " PRODUCTOID,";
          sql += " FORMATOID,";
          sql += " DOCTO,";
          sql += " FORMAT";
	      sql += " FROM CONSULTADETALLE";
	      sql += " WHERE";
	      
	      List<String> params = new ArrayList<String>();
	      
	      if(!StringUtils.isEmpty(componente.getPlataformaID())) {
	          sql += " PLATAFORMAID = ?";
	          params.add(componente.getPlataformaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getSistemaID())) {
	          sql += " AND SISTEMAID = ?";
	          params.add(componente.getSistemaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getBibliotecaId())) {
	          sql += " AND BIBLIOTECAID = ?";
	          params.add(componente.getBibliotecaId());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getClaseId())) {
	          sql += " AND CLASEID = ?";
	          params.add(componente.getClaseId());
	      }
	      
	      List<Componente> componentes = jdbcTemplate.query(
	          sql,
	          StringUtils.toStringArray(params),
	          new RowMapper<Componente>() {
	              public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
	                  Componente componente = new Componente();
	                  Blob blob = rs.getBlob("DOCTO");
                      componente.setDocto(blob.getBytes(1, (int) blob.length()));
                      componente.setPlataformaID(rs.getString("PLATAFORMAID"));
                      componente.setSistemaID(rs.getString("SISTEMAID"));
                      componente.setClaseId(rs.getString("CLASEID"));
                      componente.setBibliotecaId(rs.getString("BIBLIOTECAID"));
                      componente.setComponente(rs.getString("COMPONENTE"));
                      componente.setProductoId(rs.getString("PRODUCTOID"));
                      componente.setFormatoId(rs.getString("FORMATOID"));
                      return componente;
                  }
              });
          log.debug("componente: {}", componentes.toString());
          return componentes;
    }
	  
	  //Búsqueda de los componentes
	@Override
	public List<Componente> resultcomp(Componente componente) {
		String sql = "select distinct Plataformaid,Sistemaid,Claseid,Bibliotecaid,Componente from CONSULTADETALLE where 1=1 ";
		List<String> params = new ArrayList<String>();
		
			if(!StringUtils.isEmpty(componente.getComponente())) {
	          sql += "and componente like ?";
	          params.add(componente.getComponente());
			}
		 if(!StringUtils.isEmpty(componente.getPlataformaID())) {
	          sql += "and PLATAFORMAID = ?";
	          params.add(componente.getPlataformaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getSistemaID())) {
	          sql += " AND SISTEMAID = ?";
	          params.add(componente.getSistemaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getBibliotecaId())) {
	          sql += " AND BIBLIOTECAID = ?";
	          params.add(componente.getBibliotecaId());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getClaseId())) {
	          sql += " AND CLASEID = ?";
	          params.add(componente.getClaseId());
	      }
	      sql +="ORDER BY COMPONENTE";
		List <Componente> filcomp= jdbcTemplate.query(sql, params.toArray(),new RowMapper<Componente>() {
            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Componente compo = new Componente();
            	compo.setPlataformaID(rs.getString("PLATAFORMAID"));
            	compo.setSistemaID(rs.getString("SISTEMAID"));
            	compo.setClaseId(rs.getString("CLASEID"));
            	compo.setBibliotecaId(rs.getString("BIBLIOTECAID"));
            	compo.setComponente(rs.getString("componente"));
            	return compo; 
            }
		});
		return filcomp;
	}
	
	//Metodo para hacer la busqueda de un solo componente
	@Override
	public List<Componente> cmpsolo(String componente) {
		String sql = "select distinct Componente,Plataformaid,Sistemaid,Claseid,Bibliotecaid from CONSULTADETALLE"
				+ " where componente like ? group by(Componente,Plataformaid, sistemaid,claseid,bibliotecaid) order by COMPONENTE";
				String []parametro= new String[]{componente};
				List <Componente> filcomp= jdbcTemplate.query(sql, parametro,new RowMapper<Componente>() {
		            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	Componente compo = new Componente();
		            	compo.setComponente(rs.getString("COMPONENTE"));
		            	compo.setPlataformaID(rs.getString("PLATAFORMAID"));
		            	compo.setSistemaID(rs.getString("SISTEMAID"));
		            	compo.setClaseId(rs.getString("CLASEID"));
		            	compo.setBibliotecaId(rs.getString("BIBLIOTECAID"));
		            	return compo; 
		            }
				});
				return filcomp;
	}
	
	//ESTOS DOS METODOS VAN EN LA MISMA PÁGINA
	//PARTE SUPERIOR
	@Override
	public Componente resultunico(String componente) {
		String sql = "select distinct Componente,plataformaid,sistemaid,claseid,bibliotecaid from CONSULTADETALLE "
				+ "where componente= ?";
		String []parametro= new String[]{componente};
		List <Componente> filcomp= jdbcTemplate.query(sql, parametro,new RowMapper<Componente>() {
            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Componente compo = new Componente();
            	compo.setComponente(rs.getString("componente"));
            	compo.setPlataformaID(rs.getString("PLATAFORMAID"));
            	compo.setSistemaID(rs.getString("SISTEMAID"));
            	compo.setClaseId(rs.getString("CLASEID"));
            	compo.setBibliotecaId(rs.getString("BIBLIOTECAID"));
            	return compo; 
            }
		});
		return filcomp.get(0);
	}
	
	
	//PARTE INFERIOR V2
		@Override
		public List<Componente> resultdetalle(String componente) {
			String sql = "select distinct cd.COMPONENTE, cd.PRODUCTOID, cd.FORMATOID, cd.BIBLIOTECAID, cd.CLASEID, cd.PLATAFORMAID, cd.SISTEMAID, cp.DESCRIPCION "
					+ "from CONSULTADETALLE cd, CATALOGOPRODUCTOS cp "
					+ "where COMPONENTE = ? and cd.PRODUCTOID=cp.PRODUCTOID";
			String []parametro= new String[]{componente};
			List <Componente> filcomp= jdbcTemplate.query(sql, parametro,new RowMapper<Componente>() {
	            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Componente compo = new Componente();
	            	compo.setComponente(rs.getString("COMPONENTE"));
	            	compo.setProductoId(rs.getString("PRODUCTOID"));
	            	compo.setFormatoId(rs.getString("FORMATOID"));
	            	compo.setBibliotecaId(rs.getString("bibliotecaid"));
	            	compo.setClaseId(rs.getString("CLASEID"));
	            	compo.setPlataformaID(rs.getString("PLATAFORMAID"));
	            	compo.setSistemaID(rs.getString("sistemaid"));
	            	compo.setDescripcion(rs.getString("DESCRIPCION"));
	            	return compo; 
	            }
			});
			return filcomp;
		}
	//PARTE INFERIOR
	/*@Override
	public List<Componente> resultdetalle(String componente) {
		String sql = "select distinct Componente, FORMATOID, PRODUCTOID, PLATAFORMAID, sistemaid, bibliotecaid"
				+ ",CLASEID from CONSULTADETALLE where COMPONENTE = ?";
		String []parametro= new String[]{componente};
		List <Componente> filcomp= jdbcTemplate.query(sql, parametro,new RowMapper<Componente>() {
            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Componente compo = new Componente();
            	compo.setComponente(rs.getString("COMPONENTE"));
            	compo.setProductoId(rs.getString("PRODUCTOID"));
            	compo.setFormatoId(rs.getString("FORMATOID"));
            	compo.setBibliotecaId(rs.getString("bibliotecaid"));
            	compo.setClaseId(rs.getString("CLASEID"));
            	compo.setPlataformaID(rs.getString("PLATAFORMAID"));
            	compo.setSistemaID(rs.getString("sistemaid"));
            	return compo; 
            }
		});
		return filcomp;
	}*//*
	
	@Override
	public Componente prueba(String componente) {
		String sql = "SELECT DOCTO FROM CONSULTADETALLE WHERE FORMATOID='XLS' AND ROWNUM=1 ";
		String []parametro= new String[]{componente};
		List <Componente> filcomp= jdbcTemplate.query(sql, new RowMapper<Componente>() {
            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Componente compo = new Componente();
            	Blob blob = rs.getBlob("docto");
            	compo.setDocto(blob.getBytes(1, (int)blob.length()));
            	//compo.setDocto(rs.getBlob("DOCTO").getBytes(0, new Long(rs.getBlob("DOCTO").length()-1).intValue()));
            	//compo.setDocto(rs.getBinaryStream("docto"));
            	//rs.getBlob("docto");
            	return compo; 
            }
		});
		return filcomp.get(0);
	}
	
	@Override
	public Componente vistaprevia(Componente componente) {
		String sql = "SELECT DOCTO FROM CONSULTADETALLE WHERE FORMATOID= ? AND PLATAFORMAID= ? AND CLASEID= ? "
				+ "AND BIBLIOTECAID=? AND SISTEMAID = ? AND COMPONENTE=? AND PRODUCTOID=?";
		String []parametro= new String[]{componente.getFormatoId(), componente.getPlataformaID(), componente.getClaseId()
				, componente.getBibliotecaId(), componente.getSistemaID(), componente.getComponente(), componente.getProductoId()};
		List <Componente> filcomp= jdbcTemplate.query(sql, parametro, new RowMapper<Componente>() {
            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Componente compo = new Componente();
            	Blob blob = rs.getBlob("docto");
            	compo.setDocto(blob.getBytes(1, (int)blob.length()));
            	//compo.setDocto(rs.getBlob("DOCTO").getBytes(0, new Long(rs.getBlob("DOCTO").length()-1).intValue()));
            	//compo.setDocto(rs.getBinaryStream("docto"));
            	//rs.getBlob("docto");
            	return compo; 
            }
		});
		return filcomp.get(0);
	}
}
*/
