package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the inss database table.
 * 
 */
@Entity
@Table(name="inss")
@NamedQuery(name="Inss.findAll", query="SELECT i FROM Inss i")
public class Inss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(precision=10, scale=10)
	private BigDecimal percInss;

	@Column(precision=10, scale=10)
	private BigDecimal percSat;

	@Column(precision=10, scale=10)
	private BigDecimal percSenar;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="inssBean")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Inss() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPercInss() {
		return this.percInss;
	}

	public void setPercInss(BigDecimal percInss) {
		this.percInss = percInss;
	}

	public BigDecimal getPercSat() {
		return this.percSat;
	}

	public void setPercSat(BigDecimal percSat) {
		this.percSat = percSat;
	}

	public BigDecimal getPercSenar() {
		return this.percSenar;
	}

	public void setPercSenar(BigDecimal percSenar) {
		this.percSenar = percSenar;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setInssBean(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setInssBean(null);

		return naturezasoperacoe;
	}

}