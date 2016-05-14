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
        usuario.setId(id);
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
	
	@Override
	@SuppressWarnings("unchecked")
	public Usuario isValidUsuario(String nome, String senha)
	{
		String query = "Select u.id, u.nome, u.sobrenome, u.login, u.senha, u.email"
					  + " from usuario u where u.login = '" + nome + "' and u.senha = '" + senha + "'";
		List<Object[]> usuariosObjects = hibernateUtil.fetchAll(query);
		 
		if(usuariosObjects.size() == 1) 
		{
			Usuario usuarioBanco = this.getUsuarioById((int)usuariosObjects.get(0)[0]);
			return usuarioBanco;
		}
		 
		return null;
	}
	
}
