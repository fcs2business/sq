package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the icms database table.
 * 
 */
@Entity
@Table(name="icms")
@NamedQuery(name="Icms.findAll", query="SELECT i FROM Icms i")
public class Icms implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, precision=10, scale=10)
	private BigDecimal aliquota;

	@Column(precision=10, scale=10)
	private BigDecimal aliquotaComplementar;

	@Column(nullable=false)
	private byte cedSubsTribAntecipada;

	@Column(nullable=false)
	private int codTributacao;

	@Column(nullable=false)
	private byte consumidorFinal;

	@Column(nullable=false)
	private byte contSubsAntecipada;

	@Column(nullable=false)
	private byte diminuiSTFrete;

	@Column(nullable=false)
	private byte extornaIcms;

	@Column(nullable=false)
	private byte gerarCreditoST;

	@Column(nullable=false)
	private byte icmsOutVlrST;

	@Column(nullable=false)
	private byte icmsStComplementar;

	@Column(nullable=false)
	private byte icmsStRepassar;

	@Column(nullable=false)
	private byte icmsSubsTribAntecipada;

	@Column(nullable=false)
	private byte itIcmsCobrST;

	@Column(nullable=false)
	private byte itIcmsDiferido;

	@Column(nullable=false)
	private byte itIcmsSuspenso;

	@Column(nullable=false)
	private byte naoTributada;

	@Column(precision=10, scale=10)
	private BigDecimal percDescontoIcms;

	@Column(precision=10, scale=10)
	private BigDecimal percDescZonaFranca;

	@Column(precision=10, scale=10)
	private BigDecimal percIcmsSubsTrib;

	@Column(precision=10, scale=10)
	private BigDecimal percReducaoIcms;

	@Column(nullable=false)
	private byte situacaoTributaria;

	@Column(nullable=false)
	private int tipoBaseIcms;

	//bi-directional many-to-one association to BasesIcms
	@ManyToOne
	@JoinColumn(name="baseIcms", nullable=false)
	private BasesIcms basesicm;

	//bi-directional many-to-one association to DestReducao
	@ManyToOne
	@JoinColumn(name="destReducao", nullable=false)
	private DestReducao destreducao;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="icm")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Icms() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAliquota() {
		return this.aliquota;
	}

	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}

	public BigDecimal getAliquotaComplementar() {
		return this.aliquotaComplementar;
	}

	public void setAliquotaComplementar(BigDecimal aliquotaComplementar) {
		this.aliquotaComplementar = aliquotaComplementar;
	}

	public byte getCedSubsTribAntecipada() {
		return this.cedSubsTribAntecipada;
	}

	public void setCedSubsTribAntecipada(byte cedSubsTribAntecipada) {
		this.cedSubsTribAntecipada = cedSubsTribAntecipada;
	}

	public int getCodTributacao() {
		return this.codTributacao;
	}

	public void setCodTributacao(int codTributacao) {
		this.codTributacao = codTributacao;
	}

	public byte getConsumidorFinal() {
		return this.consumidorFinal;
	}

	public void setConsumidorFinal(byte consumidorFinal) {
		this.consumidorFinal = consumidorFinal;
	}

	public byte getContSubsAntecipada() {
		return this.contSubsAntecipada;
	}

	public void setContSubsAntecipada(byte contSubsAntecipada) {
		this.contSubsAntecipada = contSubsAntecipada;
	}

	public byte getDiminuiSTFrete() {
		return this.diminuiSTFrete;
	}

	public void setDiminuiSTFrete(byte diminuiSTFrete) {
		this.diminuiSTFrete = diminuiSTFrete;
	}

	public byte getExtornaIcms() {
		return this.extornaIcms;
	}

	public void setExtornaIcms(byte extornaIcms) {
		this.extornaIcms = extornaIcms;
	}

	public byte getGerarCreditoST() {
		return this.gerarCreditoST;
	}

	public void setGerarCreditoST(byte gerarCreditoST) {
		this.gerarCreditoST = gerarCreditoST;
	}

	public byte getIcmsOutVlrST() {
		return this.icmsOutVlrST;
	}

	public void setIcmsOutVlrST(byte icmsOutVlrST) {
		this.icmsOutVlrST = icmsOutVlrST;
	}

	public byte getIcmsStComplementar() {
		return this.icmsStComplementar;
	}

	public void setIcmsStComplementar(byte icmsStComplementar) {
		this.icmsStComplementar = icmsStComplementar;
	}

	public byte getIcmsStRepassar() {
		return this.icmsStRepassar;
	}

	public void setIcmsStRepassar(byte icmsStRepassar) {
		this.icmsStRepassar = icmsStRepassar;
	}

	public byte getIcmsSubsTribAntecipada() {
		return this.icmsSubsTribAntecipada;
	}

	public void setIcmsSubsTribAntecipada(byte icmsSubsTribAntecipada) {
		this.icmsSubsTribAntecipada = icmsSubsTribAntecipada;
	}

	public byte getItIcmsCobrST() {
		return this.itIcmsCobrST;
	}

	public void setItIcmsCobrST(byte itIcmsCobrST) {
		this.itIcmsCobrST = itIcmsCobrST;
	}

	public byte getItIcmsDiferido() {
		return this.itIcmsDiferido;
	}

	public void setItIcmsDiferido(byte itIcmsDiferido) {
		this.itIcmsDiferido = itIcmsDiferido;
	}

	public byte getItIcmsSuspenso() {
		return this.itIcmsSuspenso;
	}

	public void setItIcmsSuspenso(byte itIcmsSuspenso) {
		this.itIcmsSuspenso = itIcmsSuspenso;
	}

	public byte getNaoTributada() {
		return this.naoTributada;
	}

	public void setNaoTributada(byte naoTributada) {
		this.naoTributada = naoTributada;
	}

	public BigDecimal getPercDescontoIcms() {
		return this.percDescontoIcms;
	}

	public void setPercDescontoIcms(BigDecimal percDescontoIcms) {
		this.percDescontoIcms = percDescontoIcms;
	}

	public BigDecimal getPercDescZonaFranca() {
		return this.percDescZonaFranca;
	}

	public void setPercDescZonaFranca(BigDecimal percDescZonaFranca) {
		this.percDescZonaFranca = percDescZonaFranca;
	}

	public BigDecimal getPercIcmsSubsTrib() {
		return this.percIcmsSubsTrib;
	}

	public void setPercIcmsSubsTrib(BigDecimal percIcmsSubsTrib) {
		this.percIcmsSubsTrib = percIcmsSubsTrib;
	}

	public BigDecimal getPercReducaoIcms() {
		return this.percReducaoIcms;
	}

	public void setPercReducaoIcms(BigDecimal percReducaoIcms) {
		this.percReducaoIcms = percReducaoIcms;
	}

	public byte getSituacaoTributaria() {
		return this.situacaoTributaria;
	}

	public void setSituacaoTributaria(byte situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	public int getTipoBaseIcms() {
		return this.tipoBaseIcms;
	}

	public void setTipoBaseIcms(int tipoBaseIcms) {
		this.tipoBaseIcms = tipoBaseIcms;
	}

	public BasesIcms getBasesicm() {
		return this.basesicm;
	}

	public void setBasesicm(BasesIcms basesicm) {
		this.basesicm = basesicm;
	}

	public DestReducao getDestreducao() {
		return this.destreducao;
	}

	public void setDestreducao(DestReducao destreducao) {
		this.destreducao = destreducao;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setIcm(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setIcm(null);

		return naturezasoperacoe;
	}

}