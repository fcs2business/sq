package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Perfil
 * 
 */
@Entity
@Table(name = "Perfis")
public class Perfil implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false, insertable = true)
	@JsonManagedReference
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name = "papel", nullable = false, insertable = true)
	@JsonManagedReference
	private Papel papel;

	@ManyToOne
	@JoinColumn(name = "credencial", nullable = false, insertable = true)
	@JsonManagedReference
	private Credencial credencial;
	private static final long serialVersionUID = 1L;

	public Perfil() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
