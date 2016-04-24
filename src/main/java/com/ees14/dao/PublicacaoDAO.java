package com.ees14.dao;

import java.util.List;

import com.ees14.entity.Publicacao;

public interface PublicacaoDAO {
	public int createPublicacao(Publicacao publicacao);
    public Publicacao updatePublicacao(Publicacao publicacao);
    public void deletePublicacao(int id);
    public List<Publicacao> getAllPublicacoes();
    public Publicacao getPublicacaoById(int id);
}
