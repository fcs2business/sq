package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamentos database table.
 * 
 */
@Entity
@Table(name="departamentos")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=200)
	private String descricao;

	@Column(nullable=false, length=100)
	private String nome;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresa", nullable=false)
	private Empresa empresa;

	public Departamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresaBean() {
		return this.empresa;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresa = empresaBean;
	}

}