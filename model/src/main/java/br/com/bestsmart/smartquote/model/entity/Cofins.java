package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the cofins database table.
 * 
 */
@Entity
@Table(name="cofins")
@NamedQuery(name="Cofins.findAll", query="SELECT c FROM Cofins c")
public class Cofins implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int codTributacao;

	@Column(precision=10, scale=10)
	private BigDecimal descZFM;

	@Column(precision=10, scale=10)
	private BigDecimal percAnterior;

	@Column(precision=10, scale=10)
	private BigDecimal percExterno;

	@Column(precision=10, scale=10)
	private BigDecimal percInterno;

	@Column(precision=10, scale=10)
	private BigDecimal percRetencao;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="cofin")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Cofins() {
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

	public BigDecimal getDescZFM() {
		return this.descZFM;
	}

	public void setDescZFM(BigDecimal descZFM) {
		this.descZFM = descZFM;
	}

	public BigDecimal getPercAnterior() {
		return this.percAnterior;
	}

	public void setPercAnterior(BigDecimal percAnterior) {
		this.percAnterior = percAnterior;
	}

	public BigDecimal getPercExterno() {
		return this.percExterno;
	}

	public void setPercExterno(BigDecimal percExterno) {
		this.percExterno = percExterno;
	}

	public BigDecimal getPercInterno() {
		return this.percInterno;
	}

	public void setPercInterno(BigDecimal percInterno) {
		this.percInterno = percInterno;
	}

	public BigDecimal getPercRetencao() {
		return this.percRetencao;
	}

	public void setPercRetencao(BigDecimal percRetencao) {
		this.percRetencao = percRetencao;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setCofin(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setCofin(null);

		return naturezasoperacoe;
	}

}