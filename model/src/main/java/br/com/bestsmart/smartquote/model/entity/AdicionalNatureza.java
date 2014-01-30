package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the adicionaisnaturezas database table.
 * 
 */
@Entity
@Table(name = "adicionaisnaturezas")
@NamedQuery(name = "AdicionalNatureza.findAll", query = "SELECT a FROM AdicionalNatureza a")
public class AdicionalNatureza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private byte alterarValorItTerceiros;

	@Column(nullable = false)
	private byte compraVendaAtivo;

	@Column(nullable = false)
	private byte drawback;

	@Column(nullable = false)
	private byte geraFichaAutomatico;

	@Column(nullable = false)
	private byte gerarDevValor;

	@Column(nullable = false)
	private byte gerarNotaFaturamento;

	@Column(nullable = false)
	private byte inicioCreditoAutomatico;

	@Column(nullable = false)
	private byte memExportacao;

	@Column(nullable = false)
	private byte naturezaBonificacao;

	@Column(nullable = false)
	private byte notaComercio;

	@Column(nullable = false)
	private byte notaPropria;

	@Column(nullable = false)
	private byte notaRateio;

	@Column(nullable = false)
	private byte operacaoTransferencia;

	@Column(nullable = false)
	private byte opTerceiros;

	@Column(nullable = false)
	private byte opTriangular;

	private int tpCompraVenda;

	@Column(nullable = false)
	private int tpDevolucaoConsig;

	@Column(nullable = false)
	private int tpOpTerceiro;

	private int valNaturezaBonificacao;

	@Column(nullable = false)
	private byte vendaAmbulante;

	@Column(precision = 10, scale = 10)
	private BigDecimal vvItTerceiros;

	// bi-directional many-to-one association to NaturezaOperacao
	@ManyToOne
	@JoinColumn(name = "naturezaComplementar", nullable = false)
	private NaturezaOperacao naturezasoperacoe;

	// bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy = "adicionaisnatureza")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public AdicionalNatureza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAlterarValorItTerceiros() {
		return this.alterarValorItTerceiros;
	}

	public void setAlterarValorItTerceiros(byte alterarValorItTerceiros) {
		this.alterarValorItTerceiros = alterarValorItTerceiros;
	}

	public byte getCompraVendaAtivo() {
		return this.compraVendaAtivo;
	}

	public void setCompraVendaAtivo(byte compraVendaAtivo) {
		this.compraVendaAtivo = compraVendaAtivo;
	}

	public byte getDrawback() {
		return this.drawback;
	}

	public void setDrawback(byte drawback) {
		this.drawback = drawback;
	}

	public byte getGeraFichaAutomatico() {
		return this.geraFichaAutomatico;
	}

	public void setGeraFichaAutomatico(byte geraFichaAutomatico) {
		this.geraFichaAutomatico = geraFichaAutomatico;
	}

	public byte getGerarDevValor() {
		return this.gerarDevValor;
	}

	public void setGerarDevValor(byte gerarDevValor) {
		this.gerarDevValor = gerarDevValor;
	}

	public byte getGerarNotaFaturamento() {
		return this.gerarNotaFaturamento;
	}

	public void setGerarNotaFaturamento(byte gerarNotaFaturamento) {
		this.gerarNotaFaturamento = gerarNotaFaturamento;
	}

	public byte getInicioCreditoAutomatico() {
		return this.inicioCreditoAutomatico;
	}

	public void setInicioCreditoAutomatico(byte inicioCreditoAutomatico) {
		this.inicioCreditoAutomatico = inicioCreditoAutomatico;
	}

	public byte getMemExportacao() {
		return this.memExportacao;
	}

	public void setMemExportacao(byte memExportacao) {
		this.memExportacao = memExportacao;
	}

	public byte getNaturezaBonificacao() {
		return this.naturezaBonificacao;
	}

	public void setNaturezaBonificacao(byte naturezaBonificacao) {
		this.naturezaBonificacao = naturezaBonificacao;
	}

	public byte getNotaComercio() {
		return this.notaComercio;
	}

	public void setNotaComercio(byte notaComercio) {
		this.notaComercio = notaComercio;
	}

	public byte getNotaPropria() {
		return this.notaPropria;
	}

	public void setNotaPropria(byte notaPropria) {
		this.notaPropria = notaPropria;
	}

	public byte getNotaRateio() {
		return this.notaRateio;
	}

	public void setNotaRateio(byte notaRateio) {
		this.notaRateio = notaRateio;
	}

	public byte getOperacaoTransferencia() {
		return this.operacaoTransferencia;
	}

	public void setOperacaoTransferencia(byte operacaoTransferencia) {
		this.operacaoTransferencia = operacaoTransferencia;
	}

	public byte getOpTerceiros() {
		return this.opTerceiros;
	}

	public void setOpTerceiros(byte opTerceiros) {
		this.opTerceiros = opTerceiros;
	}

	public byte getOpTriangular() {
		return this.opTriangular;
	}

	public void setOpTriangular(byte opTriangular) {
		this.opTriangular = opTriangular;
	}

	public int getTpCompraVenda() {
		return this.tpCompraVenda;
	}

	public void setTpCompraVenda(int tpCompraVenda) {
		this.tpCompraVenda = tpCompraVenda;
	}

	public int getTpDevolucaoConsig() {
		return this.tpDevolucaoConsig;
	}

	public void setTpDevolucaoConsig(int tpDevolucaoConsig) {
		this.tpDevolucaoConsig = tpDevolucaoConsig;
	}

	public int getTpOpTerceiro() {
		return this.tpOpTerceiro;
	}

	public void setTpOpTerceiro(int tpOpTerceiro) {
		this.tpOpTerceiro = tpOpTerceiro;
	}

	public int getValNaturezaBonificacao() {
		return this.valNaturezaBonificacao;
	}

	public void setValNaturezaBonificacao(int valNaturezaBonificacao) {
		this.valNaturezaBonificacao = valNaturezaBonificacao;
	}

	public byte getVendaAmbulante() {
		return this.vendaAmbulante;
	}

	public void setVendaAmbulante(byte vendaAmbulante) {
		this.vendaAmbulante = vendaAmbulante;
	}

	public BigDecimal getVvItTerceiros() {
		return this.vvItTerceiros;
	}

	public void setVvItTerceiros(BigDecimal vvItTerceiros) {
		this.vvItTerceiros = vvItTerceiros;
	}

	public NaturezaOperacao getNaturezasoperacoe() {
		return this.naturezasoperacoe;
	}

	public void setNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		this.naturezasoperacoe = naturezasoperacoe;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setAdicionaisnatureza(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setAdicionaisnatureza(null);

		return naturezasoperacoe;
	}

}
