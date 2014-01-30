package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the parametrosglobais database table.
 * 
 */
@Entity
@Table(name = "parametrosglobais")
@NamedQuery(name = "ParametroGlobal.findAll", query = "SELECT p FROM ParametroGlobal p")
public class ParametroGlobal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 200)
	private String name;

	@Column(nullable = false, length = 200)
	private String value;

	// bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false)
	@JsonManagedReference
	private Empresa empresa;

	public ParametroGlobal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
