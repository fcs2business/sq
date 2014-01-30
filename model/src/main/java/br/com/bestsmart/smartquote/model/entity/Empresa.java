package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name = "empresas")
@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 14)
	private String cnpj;

	@Column(nullable = false, length = 50)
	private String codigo;

	@Column(nullable = false, length = 50)
	private String codigoIbge;

	@Column(nullable = false, length = 5)
	private String codigoNire;

	@Column(nullable = false, length = 50)
	private String inscricaoEstadual;

	@Column(length = 200)
	private String inscricaoMunicipal;

	@Column(nullable = false, length = 200)
	private String nomeFantasia;

	@Column(nullable = false, length = 100)
	private String razaoSocial;

	// bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy = "empresa")
	private Set<Departamento> departamentos;

	// bi-directional many-to-one association to Endereco
	@ManyToMany
	@JoinTable(
			name = "empresasEnderecos",
			joinColumns = { @JoinColumn(name = "endereco", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "empresa", referencedColumnName = "id") })
	private Set<Endereco> enderecos;

	// bi-directional many-to-one association to Telefone
	@ManyToMany
	@JoinTable(
			name = "empresasTelefones",
			joinColumns = { @JoinColumn(name = "telefone", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "empresa", referencedColumnName = "id") })
	private Set<Telefone> telefones;

	@OneToMany(mappedBy = "empresa")
	@JsonBackReference
	private Set<Perfil> perfis = new HashSet<Perfil>();

	// bi-directional many-to-one association to ParametroGlobal
	@OneToMany(mappedBy = "empresa")
	@JsonBackReference
	private Set<ParametroGlobal> parametrosGlobais;

	public Empresa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoIbge() {
		return this.codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getCodigoNire() {
		return this.codigoNire;
	}

	public void setCodigoNire(String codigoNire) {
		this.codigoNire = codigoNire;
	}

	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return this.inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setEmpresaBean(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setEmpresaBean(null);

		return departamento;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<ParametroGlobal> getParametrosGlobais() {
		return this.parametrosGlobais;
	}

	public void setParametrosGlobais(Set<ParametroGlobal> parametrosGlobais) {
		this.parametrosGlobais = parametrosGlobais;
	}

	public ParametroGlobal addParametroGlobal(ParametroGlobal parametroGlobal) {
		getParametrosGlobais().add(parametroGlobal);
		parametroGlobal.setEmpresa(this);

		return parametroGlobal;
	}

	public ParametroGlobal removeParametrosGlobal(ParametroGlobal parametroGlobal) {
		getParametrosGlobais().remove(parametroGlobal);
		parametroGlobal.setEmpresa(null);

		return parametroGlobal;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
