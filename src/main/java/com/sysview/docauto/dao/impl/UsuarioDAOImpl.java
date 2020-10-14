package com.sysview.docauto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Usuario;

@Component("usuarioDao")
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Usuario> getUsuario() {
		log.debug("Consultando Usuarios...");
	
        List<Usuario> user= jdbcTemplate.query(
        "select * from USUARIOPROPIO",
        new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Usuario user = new Usuario();
            	user.setUsuario(rs.getString("USUARIOPROPIO"));
            	user.setNombreusr(rs.getString("USUARIOPROPIONOMBRE"));
            	user.setApellidopat(rs.getString("USUARIOPROPIOPATERNO"));
            	user.setApellidomat(rs.getString("USUARIOPROPIOMATERNO"));
                user.setPassword(rs.getString("USUARIOPROPIOPASSWORD"));
                user.setCorreo(rs.getString("USUARIOPROPIOCORREO"));
                return user;
            }
        });
        log.debug("usuario: {}", user.toString());
        return user;
	}

	
		public void insertUsuario(Usuario user) {	
		log.debug("Creando Usuario...");
		String sql="insert into USUARIOPROPIO (usuariopropio,USUARIOPROPIONOMBRE,USUARIOPROPIOPATERNO,"
				+ "USUARIOPROPIOMATERNO,USUARIOPROPIOPASSWORD,USUARIOPROPIOCORREO,ROL) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {user.getUsuario(),user.getNombreusr(),user.getApellidopat(),user.getApellidomat(),
				user.getPassword(),user.getCorreo(),user.getRol()});        
	}

	
		
	@Override
	public void updateUsuario(Usuario user) {
		String sql="UPDATE USUARIOPROPIO set USUARIOPROPIONOMBRE = ?, USUARIOPROPIOPATERNO = ?, "
				+ "USUARIOPROPIOMATERNO = ?, USUARIOPROPIOPASSWORD = ?, USUARIOPROPIOCORREO = ? where USUARIOPROPIO=?";
						
		jdbcTemplate.update(sql, new Object[]{user.getNombreusr(), user.getApellidopat(), 
				user.getApellidomat(),user.getPassword(),user.getCorreo(),user.getUsuario()});		
	}  
		
	@Override
	public void deleteUsuario(Usuario user) {
		String sql="delete from USUARIOPROPIO where USUARIOPROPIO=?";
		jdbcTemplate.update(sql, user.getUsuario());		
	}
	
	//Parte superior de las págs. (usuariologueado)
	@Override
	public Usuario getunusr(String user) {
        String []parametro= new String[]{user};
        	List<Usuario> usuario= jdbcTemplate.query(
        	        "select USUARIOPROPIO from USUARIOPROPIO where USUARIOPROPIO=?",
        	        parametro, new RowMapper<Usuario>(){
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Usuario user = new Usuario();
            	user.setUsuario(rs.getString("USUARIOPROPIO"));
            	return user;
            }
        });
        return usuario.get(0);
	}
	
}