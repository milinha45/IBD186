package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EST_ESTADO")
public class Estado {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "EST_ID")
	private Long id;
	
	@Column(name = "EST_NOME", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "EST_SIGLA", unique=true, length = 2, nullable = false)
	private String sigla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private List<Empresa> empresas;


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/**
	 * @return the empresas
	 */
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	/**
	 * @param empresas the empresas to set
	 */
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
}
