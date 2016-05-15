package com.ees14.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 6326855784634020898L;
	private int id;
	private String nome;
	private String sobrenome;
	private String login;
	private String senha;
	private String email;
	private Set<Publicacao> publicacoes = new HashSet<Publicacao>(0);

	public Usuario() {
	}

	public Usuario(int id) {
		this.id = id;
	}

	public Usuario(int id, String nome, String sobrenome, String login, String senha, String email,
			Set<Publicacao> publicacoes) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.publicacoes = publicacoes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "sobrenome")
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name = "login")
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "senha")
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
