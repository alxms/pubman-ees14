package com.ees14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ees14.dao.UsuarioDAO;
import com.ees14.entity.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	public UsuarioServiceImpl() {
		System.out.println("UsuarioServiceImpl()");
	}
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public int createUsuario(Usuario usuario) {
		return usuarioDAO.createUsuario(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioDAO.deleteUsuario(id);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioDAO.getAllUsuarios();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return usuarioDAO.getUsuarioById(id);
	}
}
