package com.ees14.dao;

import com.ees14.entity.Publicacao;
import com.ees14.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PublicacaoDAOImpl implements PublicacaoDAO {

	public PublicacaoDAOImpl() {
    	System.out.println("PublicacaoDAOImpl()");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
    public int createPublicacao(Publicacao publicacao) {        
        return (int) hibernateUtil.create(publicacao);
    }

	@Override
    public Publicacao updatePublicacao(Publicacao publicacao) {        
        return hibernateUtil.update(publicacao);
    }
	
	@Override
    public void deletePublicacao(int id) {
    	Publicacao publicacao = new Publicacao();
        publicacao.setIdPublicacao(id);
        hibernateUtil.delete(publicacao);
    }

	@Override
    public List<Publicacao> getAllPublicacoes() {        
        return hibernateUtil.fetchAll(Publicacao.class);
    }

	@Override
    public Publicacao getPublicacaoById(int id) {
        return hibernateUtil.fetchById(id, Publicacao.class);
    }

/*	@SuppressWarnings("unchecked")
	public List<Publicacao> getAllPublicacoes(int idUsuario) { 
		String query = "SELECT p.* FROM publicacao p WHERE e.name like '%"+ idUsuario +"%'";
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Publicacao> employees = new ArrayList<Publicacao>();
		for(Object[] employeeObject: employeeObjects) {
			Publicacao employee = new Publicacao();
			long id = ((BigInteger) employeeObject[0]).longValue();			
			int age = (int) employeeObject[1];
			String name = (String) employeeObject[2];
			float salary = (float) employeeObject[3];
			employee.setId(id);
			employee.setName(name);
			employee.setAge(age);
			employee.setSalary(salary);
			employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}*/
}
