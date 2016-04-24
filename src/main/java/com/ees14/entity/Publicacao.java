package com.ees14.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publicacao")
public class Publicacao implements java.io.Serializable {

	private static final long serialVersionUID = -4901590559819816551L;
	private int idPublicacao;
	private String titulo;
	private Integer ano;
	private Boolean internacional;
	private String autores;
	private Integer tipo;
	private Integer status;
	private String link;
	private String resumo;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Publicacao() {
	}

	public Publicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Publicacao(int idPublicacao, String titulo, Integer ano, Boolean internacional, String autores, Integer tipo,
			Integer status, String link, String resumo, Set<Usuario> usuarios) {
		this.idPublicacao = idPublicacao;
		this.titulo = titulo;
		this.ano = ano;
		this.internacional = internacional;
		this.autores = autores;
		this.tipo = tipo;
		this.status = status;
		this.link = link;
		this.resumo = resumo;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getIdPublicacao() {
		return this.idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "ano")
	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Column(name = "internacional")
	public Boolean getInternacional() {
		return this.internacional;
	}

	public void setInternacional(Boolean internacional) {
		this.internacional = internacional;
	}

	@Column(name = "autores")
	public String getAutores() {
		return this.autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	@Column(name = "tipo")
	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "resumo", length = 1024)
	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "publicacaos")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String toString(){
		return "Publicacao{" +
                "idPublicacao='" + getIdPublicacao() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", ano='" + getAno() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
	}
}
