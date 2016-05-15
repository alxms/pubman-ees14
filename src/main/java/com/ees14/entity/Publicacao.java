package com.ees14.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "publicacao")
public class Publicacao implements java.io.Serializable {

	private static final long serialVersionUID = -4901590559819816551L;
	private int idPublicacao;
	private String titulo;
	private Integer ano;
	private boolean internacional;
	private String autores;
	private Tipo tipo;
	private Status status;
	private String link;
	private String resumo;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Publicacao() {
	}

	public Publicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Publicacao(int idPublicacao, String titulo, Integer ano, Boolean internacional, String autores, Tipo tipo,
			Status status, String link, String resumo, Set<Usuario> usuarios) {
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
	public boolean getInternacional() {
		return this.internacional;
	}

	public void setInternacional(boolean internacional) {
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
	@Enumerated(EnumType.ORDINAL)
	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_publicacao", 
			   joinColumns = { @JoinColumn(name = "id_publicacao", 
			   							   nullable = false, 
			   							   updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "id_usuario", 
			   									  nullable = false, 
			   									  updatable = false) })
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
	
	//transient properties
	@Transient
	public String getAlcance()
	{
		if(this.internacional) return "Internacional";
		return "Nacional";
	}
	
	@Transient
	public String getTipoStr()
	{
		return this.getTipo().getValue();
	}
	
	@Transient
	public String getStatusStr()
	{
		return this.getStatus().getValue();
	}
}
