package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the documentosfiscais database table.
 * 
 */
@Entity
@Table(name="documentosfiscais")
@NamedQuery(name="DocumentoFiscal.findAll", query="SELECT d FROM DocumentoFiscal d")
public class DocumentoFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=2)
	private String modelo;

	@Column(length=2)
	private String modeloCupomFiscal;

	//bi-directional many-to-one association to EspecieDocFiscal
	@ManyToOne
	@JoinColumn(name="especie", nullable=false)
	private EspecieDocFiscal especiedocfiscal;

	//bi-directional many-to-one association to Mensagem
	@ManyToOne
	@JoinColumn(name="mensagem", nullable=false)
	private Mensagem mensagen;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="documentosfiscai")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public DocumentoFiscal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModeloCupomFiscal() {
		return this.modeloCupomFiscal;
	}

	public void setModeloCupomFiscal(String modeloCupomFiscal) {
		this.modeloCupomFiscal = modeloCupomFiscal;
	}

	public EspecieDocFiscal getEspeciedocfiscal() {
		return this.especiedocfiscal;
	}

	public void setEspeciedocfiscal(EspecieDocFiscal especiedocfiscal) {
		this.especiedocfiscal = especiedocfiscal;
	}

	public Mensagem getMensagen() {
		return this.mensagen;
	}

	public void setMensagen(Mensagem mensagen) {
		this.mensagen = mensagen;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setDocumentosfiscai(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setDocumentosfiscai(null);

		return naturezasoperacoe;
	}

}