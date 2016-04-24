package com.ees14.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ees14.entity.Usuario;
import com.ees14.util.HibernateUtil;


@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	public UsuarioDAOImpl() {
    	System.out.println("UsuarioDAOImpl()");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
    public int createUsuario(Usuario usuario) {        
        return (int) hibernateUtil.create(usuario);
    }

	@Override
    public Usuario updateUsuario(Usuario usuario) {        
        return hibernateUtil.update(usuario);
    }

	@Override
    public void deleteUsuario(int id) {
    	Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        hibernateUtil.delete(usuario);
    }

	@Override
    public List<Usuario> getAllUsuarios() {        
        return hibernateUtil.fetchAll(Usuario.class);
    }

	@Override
    public Usuario getUsuarioById(int id) {
        return hibernateUtil.fetchById(id, Usuario.class);
    }
}
