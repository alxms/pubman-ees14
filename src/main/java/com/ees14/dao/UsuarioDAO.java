package com.ees14.dao;

import java.util.List;

import com.ees14.entity.Usuario;

public interface UsuarioDAO {
	public int createUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioById(int id);
}
