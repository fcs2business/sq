package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(length = 11)
	private String cpf;

	@Column(nullable = false, length = 200)
	private String nome;

	// bi-directional many-to-one association to Credencial
	@OneToMany
	private Set<Credencial> credenciais;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Credencial> getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Set<Credencial> credenciais) {
		this.credenciais = credenciais;
	}

	public Credencial addCredencial(Credencial credencial) {
		getCredenciais().add(credencial);
		credencial.setUsuario(this);
		return credencial;

	}
}
