package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the iss database table.
 * 
 */
@Entity
@Table(name="iss")
@NamedQuery(name="Iss.findAll", query="SELECT i FROM Iss i")
public class Iss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private int codTributacao;

	@Column(nullable=false)
	private byte consideraIcmsOutNfe;

	@Column(nullable=false, precision=10, scale=10)
	private BigDecimal irrf;

	private byte naturezaVinculada;

	@Column(precision=10, scale=10)
	private BigDecimal reducaoIss;

	@Column(nullable=false)
	private byte retemIrFonte;

	@Column(nullable=false)
	private byte retemIssFonte;

	//bi-directional many-to-one association to TipoBase
	@ManyToOne
	@JoinColumn(name="tipoBase", nullable=false)
	private TipoBase tiposbase;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="issBean")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Iss() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodTributacao() {
		return this.codTributacao;
	}

	public void setCodTributacao(int codTributacao) {
		this.codTributacao = codTributacao;
	}

	public byte getConsideraIcmsOutNfe() {
		return this.consideraIcmsOutNfe;
	}

	public void setConsideraIcmsOutNfe(byte consideraIcmsOutNfe) {
		this.consideraIcmsOutNfe = consideraIcmsOutNfe;
	}

	public BigDecimal getIrrf() {
		return this.irrf;
	}

	public void setIrrf(BigDecimal irrf) {
		this.irrf = irrf;
	}

	public byte getNaturezaVinculada() {
		return this.naturezaVinculada;
	}

	public void setNaturezaVinculada(byte naturezaVinculada) {
		this.naturezaVinculada = naturezaVinculada;
	}

	public BigDecimal getReducaoIss() {
		return this.reducaoIss;
	}

	public void setReducaoIss(BigDecimal reducaoIss) {
		this.reducaoIss = reducaoIss;
	}

	public byte getRetemIrFonte() {
		return this.retemIrFonte;
	}

	public void setRetemIrFonte(byte retemIrFonte) {
		this.retemIrFonte = retemIrFonte;
	}

	public byte getRetemIssFonte() {
		return this.retemIssFonte;
	}

	public void setRetemIssFonte(byte retemIssFonte) {
		this.retemIssFonte = retemIssFonte;
	}

	public TipoBase getTiposbase() {
		return this.tiposbase;
	}

	public void setTiposbase(TipoBase tiposbase) {
		this.tiposbase = tiposbase;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setIssBean(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setIssBean(null);

		return naturezasoperacoe;
	}

}