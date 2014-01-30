package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the credenciais database table.
 * 
 */
@Entity
@Table(name = "credenciais")
public class Credencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private boolean bloqueado;

	@Temporal(TemporalType.DATE)
	private Date dataExpiracao;

	@Column(length = 50)
	private String email;

	@Column(nullable = false, length = 30, unique = true)
	private String login;

	@Column(nullable = false, length = 200)
	private String senha;

	@OneToMany(mappedBy = "credencial")
	@JsonBackReference
	private Set<Perfil> perfis = new HashSet<Perfil>();

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;

	public Credencial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Date getDataExpiracao() {
		return this.dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfis().add(perfil);
		perfil.setCredencial(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfis().remove(perfil);
		perfil.setCredencial(null);

		return perfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
