package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_EMPRESA")
public class Empresa {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
	private Long id;
	
	@Column(name = "EMP_CNPJ", unique=true, length = 16, nullable = false)
	private String cnpj;
	
	@Column(name = "EMP_NOME", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "EST_ID", nullable = true)
	private Estado estado;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empresa")
	private List<Usuario> usuarios;
	
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
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * @param cnpj the id to cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the id to nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the id to estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the usuarios
	*/
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the id to usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
