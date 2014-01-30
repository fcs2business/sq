package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the atualizacoes database table.
 * 
 */
@Entity
@Table(name = "atualizacoes")
@NamedQuery(name = "Atualizacao.findAll", query = "SELECT a FROM Atualizacao a")
public class Atualizacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private byte atualizarCotas;

	@Column(nullable = false)
	private byte atualizarEstatistica;

	@Column(nullable = false)
	private byte baixarEstoque;

	@Column(nullable = false)
	private byte calculoAutom;

	@Column(nullable = false)
	private byte contabilizacaoAutom;

	@Column(nullable = false)
	private byte crAutom;

	@Column(nullable = false)
	private byte ctrlEstoqueAutom;

	@Column(nullable = false)
	private byte estatisticaAutom;

	@Column(nullable = false)
	private byte gerarContabilizacao;

	@Column(nullable = false)
	private byte gerarDuplicata;

	@Column(nullable = false)
	private byte gerarObrigFiscal;

	@Column(nullable = false)
	private byte impressaAutom;

	@Column(nullable = false)
	private byte nfsNTribCiap;

	@Column(nullable = false)
	private byte nfsTribCiap;

	// bi-directional many-to-one association to OpEntregaFutAntecipada
	@ManyToOne
	@JoinColumn(name = "opEntregaFutAntec")
	private OpEntregaFutAntecipada opentregasfutantecipada;

	// bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy = "atualizacoe")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Atualizacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAtualizarCotas() {
		return this.atualizarCotas;
	}

	public void setAtualizarCotas(byte atualizarCotas) {
		this.atualizarCotas = atualizarCotas;
	}

	public byte getAtualizarEstatistica() {
		return this.atualizarEstatistica;
	}

	public void setAtualizarEstatistica(byte atualizarEstatistica) {
		this.atualizarEstatistica = atualizarEstatistica;
	}

	public byte getBaixarEstoque() {
		return this.baixarEstoque;
	}

	public void setBaixarEstoque(byte baixarEstoque) {
		this.baixarEstoque = baixarEstoque;
	}

	public byte getCalculoAutom() {
		return this.calculoAutom;
	}

	public void setCalculoAutom(byte calculoAutom) {
		this.calculoAutom = calculoAutom;
	}

	public byte getContabilizacaoAutom() {
		return this.contabilizacaoAutom;
	}

	public void setContabilizacaoAutom(byte contabilizacaoAutom) {
		this.contabilizacaoAutom = contabilizacaoAutom;
	}

	public byte getCrAutom() {
		return this.crAutom;
	}

	public void setCrAutom(byte crAutom) {
		this.crAutom = crAutom;
	}

	public byte getCtrlEstoqueAutom() {
		return this.ctrlEstoqueAutom;
	}

	public void setCtrlEstoqueAutom(byte ctrlEstoqueAutom) {
		this.ctrlEstoqueAutom = ctrlEstoqueAutom;
	}

	public byte getEstatisticaAutom() {
		return this.estatisticaAutom;
	}

	public void setEstatisticaAutom(byte estatisticaAutom) {
		this.estatisticaAutom = estatisticaAutom;
	}

	public byte getGerarContabilizacao() {
		return this.gerarContabilizacao;
	}

	public void setGerarContabilizacao(byte gerarContabilizacao) {
		this.gerarContabilizacao = gerarContabilizacao;
	}

	public byte getGerarDuplicata() {
		return this.gerarDuplicata;
	}

	public void setGerarDuplicata(byte gerarDuplicata) {
		this.gerarDuplicata = gerarDuplicata;
	}

	public byte getGerarObrigFiscal() {
		return this.gerarObrigFiscal;
	}

	public void setGerarObrigFiscal(byte gerarObrigFiscal) {
		this.gerarObrigFiscal = gerarObrigFiscal;
	}

	public byte getImpressaAutom() {
		return this.impressaAutom;
	}

	public void setImpressaAutom(byte impressaAutom) {
		this.impressaAutom = impressaAutom;
	}

	public byte getNfsNTribCiap() {
		return this.nfsNTribCiap;
	}

	public void setNfsNTribCiap(byte nfsNTribCiap) {
		this.nfsNTribCiap = nfsNTribCiap;
	}

	public byte getNfsTribCiap() {
		return this.nfsTribCiap;
	}

	public void setNfsTribCiap(byte nfsTribCiap) {
		this.nfsTribCiap = nfsTribCiap;
	}

	public OpEntregaFutAntecipada getOpentregasfutantecipada() {
		return this.opentregasfutantecipada;
	}

	public void setOpentregasfutantecipada(OpEntregaFutAntecipada opentregasfutantecipada) {
		this.opentregasfutantecipada = opentregasfutantecipada;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setAtualizacoe(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setAtualizacoe(null);

		return naturezasoperacoe;
	}

}
