package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Usuario;

public interface UsuarioDAO {
	
	void insertUsuario(Usuario user);
	void updateUsuario(Usuario user);
	void deleteUsuario(Usuario user);
	public List<Usuario> getUsuario(); 
	//public Usuario getuser(String usuario);
	Usuario getunusr(String user);
	
}
