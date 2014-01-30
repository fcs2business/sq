package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the ipi database table.
 * 
 */
@Entity
@Table(name="ipi")
@NamedQuery(name="Ipi.findAll", query="SELECT i FROM Ipi i")
public class Ipi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int codTributacao;

	@Column(nullable=false)
	private int codVinculacao;

	@Column(nullable=false)
	private byte escrituracaoFrete;

	@Column(nullable=false)
	private byte estorna;

	@Column(nullable=false)
	private byte impOutDanfe;

	@Column(nullable=false)
	private byte imune;

	@Column(nullable=false)
	private byte incBaseIcms;

	@Column(nullable=false)
	private byte incIcmsOut;

	@Column(nullable=false)
	private byte incluiFreteBs;

	@Column(nullable=false)
	private byte incOutBsSubs;

	@Column(nullable=false)
	private byte incOutTot;

	@Column(nullable=false)
	private byte naoTrib;

	@Column(precision=10, scale=10)
	private BigDecimal percReducao;

	//bi-directional many-to-one association to TipoBase
	@ManyToOne
	@JoinColumn(name="tipoBase", nullable=false)
	private TipoBase tiposbase;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="ipiBean")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Ipi() {
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

	public int getCodVinculacao() {
		return this.codVinculacao;
	}

	public void setCodVinculacao(int codVinculacao) {
		this.codVinculacao = codVinculacao;
	}

	public byte getEscrituracaoFrete() {
		return this.escrituracaoFrete;
	}

	public void setEscrituracaoFrete(byte escrituracaoFrete) {
		this.escrituracaoFrete = escrituracaoFrete;
	}

	public byte getEstorna() {
		return this.estorna;
	}

	public void setEstorna(byte estorna) {
		this.estorna = estorna;
	}

	public byte getImpOutDanfe() {
		return this.impOutDanfe;
	}

	public void setImpOutDanfe(byte impOutDanfe) {
		this.impOutDanfe = impOutDanfe;
	}

	public byte getImune() {
		return this.imune;
	}

	public void setImune(byte imune) {
		this.imune = imune;
	}

	public byte getIncBaseIcms() {
		return this.incBaseIcms;
	}

	public void setIncBaseIcms(byte incBaseIcms) {
		this.incBaseIcms = incBaseIcms;
	}

	public byte getIncIcmsOut() {
		return this.incIcmsOut;
	}

	public void setIncIcmsOut(byte incIcmsOut) {
		this.incIcmsOut = incIcmsOut;
	}

	public byte getIncluiFreteBs() {
		return this.incluiFreteBs;
	}

	public void setIncluiFreteBs(byte incluiFreteBs) {
		this.incluiFreteBs = incluiFreteBs;
	}

	public byte getIncOutBsSubs() {
		return this.incOutBsSubs;
	}

	public void setIncOutBsSubs(byte incOutBsSubs) {
		this.incOutBsSubs = incOutBsSubs;
	}

	public byte getIncOutTot() {
		return this.incOutTot;
	}

	public void setIncOutTot(byte incOutTot) {
		this.incOutTot = incOutTot;
	}

	public byte getNaoTrib() {
		return this.naoTrib;
	}

	public void setNaoTrib(byte naoTrib) {
		this.naoTrib = naoTrib;
	}

	public BigDecimal getPercReducao() {
		return this.percReducao;
	}

	public void setPercReducao(BigDecimal percReducao) {
		this.percReducao = percReducao;
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
		naturezasoperacoe.setIpiBean(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setIpiBean(null);

		return naturezasoperacoe;
	}

}