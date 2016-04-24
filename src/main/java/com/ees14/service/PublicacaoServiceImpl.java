package com.ees14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ees14.dao.PublicacaoDAO;
import com.ees14.entity.Publicacao;

@Service
@Transactional
public class PublicacaoServiceImpl implements PublicacaoService{

	public PublicacaoServiceImpl() {
		System.out.println("PublicacaoServiceImpl()");
	}
	
	@Autowired
	private PublicacaoDAO publicacaoDAO;
	
	@Override
	public int createPublicacao(Publicacao publicacao) {
		return publicacaoDAO.createPublicacao(publicacao);
	}

	@Override
	public Publicacao updatePublicacao(Publicacao publicacao) {
		return publicacaoDAO.updatePublicacao(publicacao);
	}

	@Override
	public void deletePublicacao(int id) {
		publicacaoDAO.deletePublicacao(id);
	}

	@Override
	public List<Publicacao> getAllPublicacoes() {
		return publicacaoDAO.getAllPublicacoes();
	}

	@Override
	public Publicacao getPublicacaoById(int id) {
		return publicacaoDAO.getPublicacaoById(id);
	}

}
