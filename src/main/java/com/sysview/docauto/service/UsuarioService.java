package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Usuario;

public interface UsuarioService {
	
	void insertUsuario(Usuario user);
	void updateUsuario(Usuario user);
	void deleteUsuario(Usuario user);
	List<Usuario> getUsuario(); 
	//Usuario getusuario(String usuario);
	Usuario loginUsuario(String usuario, String password);
}