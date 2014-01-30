package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the naturezasoperacoes database table.
 * 
 */
@Entity
@Table(name="naturezasoperacoes")
@NamedQuery(name="NaturezaOperacao.findAll", query="SELECT n FROM NaturezaOperacao n")
public class NaturezaOperacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte ativa;

	@Column(nullable=false)
	private byte considCofinsNfeEntFat;

	@Column(nullable=false)
	private byte considIcmsNfeEntFat;

	@Column(nullable=false)
	private byte considIcmsNfeEntRec;

	@Column(nullable=false)
	private byte considPisNfeEntFat;

	@Column(nullable=false)
	private byte deduzDescZfm;

	@Column(nullable=false)
	private byte icmsIncideBaseIcms;

	@Column(nullable=false)
	private byte icmsIncideTnf;

	@Column(nullable=false)
	private byte incIcmsStBaseIrRet;

	@Column(nullable=false)
	private byte incIcmsStBaseRet;

	@Column(nullable=false)
	private byte incIpiBase;

	@Column(nullable=false)
	private byte incIpiBaseRet;

	@Column(nullable=false)
	private byte incIpiOutBase;

	@Column(nullable=false)
	private byte incIpiOutBaseRet;

	@Lob
	private String narrativa;

	@Column(precision=10, scale=10)
	private BigDecimal percRetencaoCsll;

	@Column(nullable=false)
	private byte retemInssNaFonte;

	private byte suspensaoIi;

	//bi-directional many-to-one association to AdicionalNatureza
	@OneToMany(mappedBy="naturezasoperacoe")
	private Set<AdicionalNatureza> adicionaisnaturezas;

	//bi-directional many-to-one association to AdicionalNatureza
	@ManyToOne
	@JoinColumn(name="adicional", nullable=false)
	private AdicionalNatureza adicionaisnatureza;

	//bi-directional many-to-one association to Atualizacao
	@ManyToOne
	@JoinColumn(name="atualizacao", nullable=false)
	private Atualizacao atualizacoe;

	//bi-directional many-to-one association to CanalVenda
	@ManyToOne
	@JoinColumn(name="canalVenda")
	private CanalVenda canaisvenda;

	//bi-directional many-to-one association to Cfop
	@ManyToOne
	@JoinColumn(name="cfop", nullable=false)
	private Cfop cfopBean;

	//bi-directional many-to-one association to Cofins
	@ManyToOne
	@JoinColumn(name="cofins", nullable=false)
	private Cofins cofin;

	//bi-directional many-to-one association to DocumentoFiscal
	@ManyToOne
	@JoinColumn(name="documentoFiscal", nullable=false)
	private DocumentoFiscal documentosfiscai;

	//bi-directional many-to-one association to Icms
	@ManyToOne
	@JoinColumn(name="icms", nullable=false)
	private Icms icm;

	//bi-directional many-to-one association to ImpostoImportacao
	@ManyToOne
	@JoinColumn(name="impostoImportacao", nullable=false)
	private ImpostoImportacao impostoimportacao;

	//bi-directional many-to-one association to Inss
	@ManyToOne
	@JoinColumn(name="inss", nullable=false)
	private Inss inssBean;

	//bi-directional many-to-one association to Ipi
	@ManyToOne
	@JoinColumn(name="ipi", nullable=false)
	private Ipi ipiBean;

	//bi-directional many-to-one association to Iss
	@ManyToOne
	@JoinColumn(name="iss", nullable=false)
	private Iss issBean;

	//bi-directional many-to-one association to Mensagem
	@ManyToOne
	@JoinColumn(name="mensagem")
	private Mensagem mensagen;

	//bi-directional many-to-one association to Mercado
	@ManyToOne
	@JoinColumn(name="mercado", nullable=false)
	private Mercado mercadoBean;

	//bi-directional many-to-one association to Pis
	@ManyToOne
	@JoinColumn(name="pis", nullable=false)
	private Pis pi;

	//bi-directional many-to-one association to TipoNatureza
	@ManyToOne
	@JoinColumn(name="tipo", nullable=false)
	private TipoNatureza tiposnatureza;

	public NaturezaOperacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAtiva() {
		return this.ativa;
	}

	public void setAtiva(byte ativa) {
		this.ativa = ativa;
	}

	public byte getConsidCofinsNfeEntFat() {
		return this.considCofinsNfeEntFat;
	}

	public void setConsidCofinsNfeEntFat(byte considCofinsNfeEntFat) {
		this.considCofinsNfeEntFat = considCofinsNfeEntFat;
	}

	public byte getConsidIcmsNfeEntFat() {
		return this.considIcmsNfeEntFat;
	}

	public void setConsidIcmsNfeEntFat(byte considIcmsNfeEntFat) {
		this.considIcmsNfeEntFat = considIcmsNfeEntFat;
	}

	public byte getConsidIcmsNfeEntRec() {
		return this.considIcmsNfeEntRec;
	}

	public void setConsidIcmsNfeEntRec(byte considIcmsNfeEntRec) {
		this.considIcmsNfeEntRec = considIcmsNfeEntRec;
	}

	public byte getConsidPisNfeEntFat() {
		return this.considPisNfeEntFat;
	}

	public void setConsidPisNfeEntFat(byte considPisNfeEntFat) {
		this.considPisNfeEntFat = considPisNfeEntFat;
	}

	public byte getDeduzDescZfm() {
		return this.deduzDescZfm;
	}

	public void setDeduzDescZfm(byte deduzDescZfm) {
		this.deduzDescZfm = deduzDescZfm;
	}

	public byte getIcmsIncideBaseIcms() {
		return this.icmsIncideBaseIcms;
	}

	public void setIcmsIncideBaseIcms(byte icmsIncideBaseIcms) {
		this.icmsIncideBaseIcms = icmsIncideBaseIcms;
	}

	public byte getIcmsIncideTnf() {
		return this.icmsIncideTnf;
	}

	public void setIcmsIncideTnf(byte icmsIncideTnf) {
		this.icmsIncideTnf = icmsIncideTnf;
	}

	public byte getIncIcmsStBaseIrRet() {
		return this.incIcmsStBaseIrRet;
	}

	public void setIncIcmsStBaseIrRet(byte incIcmsStBaseIrRet) {
		this.incIcmsStBaseIrRet = incIcmsStBaseIrRet;
	}

	public byte getIncIcmsStBaseRet() {
		return this.incIcmsStBaseRet;
	}

	public void setIncIcmsStBaseRet(byte incIcmsStBaseRet) {
		this.incIcmsStBaseRet = incIcmsStBaseRet;
	}

	public byte getIncIpiBase() {
		return this.incIpiBase;
	}

	public void setIncIpiBase(byte incIpiBase) {
		this.incIpiBase = incIpiBase;
	}

	public byte getIncIpiBaseRet() {
		return this.incIpiBaseRet;
	}

	public void setIncIpiBaseRet(byte incIpiBaseRet) {
		this.incIpiBaseRet = incIpiBaseRet;
	}

	public byte getIncIpiOutBase() {
		return this.incIpiOutBase;
	}

	public void setIncIpiOutBase(byte incIpiOutBase) {
		this.incIpiOutBase = incIpiOutBase;
	}

	public byte getIncIpiOutBaseRet() {
		return this.incIpiOutBaseRet;
	}

	public void setIncIpiOutBaseRet(byte incIpiOutBaseRet) {
		this.incIpiOutBaseRet = incIpiOutBaseRet;
	}

	public String getNarrativa() {
		return this.narrativa;
	}

	public void setNarrativa(String narrativa) {
		this.narrativa = narrativa;
	}

	public BigDecimal getPercRetencaoCsll() {
		return this.percRetencaoCsll;
	}

	public void setPercRetencaoCsll(BigDecimal percRetencaoCsll) {
		this.percRetencaoCsll = percRetencaoCsll;
	}

	public byte getRetemInssNaFonte() {
		return this.retemInssNaFonte;
	}

	public void setRetemInssNaFonte(byte retemInssNaFonte) {
		this.retemInssNaFonte = retemInssNaFonte;
	}

	public byte getSuspensaoIi() {
		return this.suspensaoIi;
	}

	public void setSuspensaoIi(byte suspensaoIi) {
		this.suspensaoIi = suspensaoIi;
	}

	public Set<AdicionalNatureza> getAdicionaisnaturezas() {
		return this.adicionaisnaturezas;
	}

	public void setAdicionaisnaturezas(Set<AdicionalNatureza> adicionaisnaturezas) {
		this.adicionaisnaturezas = adicionaisnaturezas;
	}

	public AdicionalNatureza addAdicionaisnatureza(AdicionalNatureza adicionaisnatureza) {
		getAdicionaisnaturezas().add(adicionaisnatureza);
		adicionaisnatureza.setNaturezasoperacoe(this);

		return adicionaisnatureza;
	}

	public AdicionalNatureza removeAdicionaisnatureza(AdicionalNatureza adicionaisnatureza) {
		getAdicionaisnaturezas().remove(adicionaisnatureza);
		adicionaisnatureza.setNaturezasoperacoe(null);

		return adicionaisnatureza;
	}

	public AdicionalNatureza getAdicionaisnatureza() {
		return this.adicionaisnatureza;
	}

	public void setAdicionaisnatureza(AdicionalNatureza adicionaisnatureza) {
		this.adicionaisnatureza = adicionaisnatureza;
	}

	public Atualizacao getAtualizacoe() {
		return this.atualizacoe;
	}

	public void setAtualizacoe(Atualizacao atualizacoe) {
		this.atualizacoe = atualizacoe;
	}

	public CanalVenda getCanaisvenda() {
		return this.canaisvenda;
	}

	public void setCanaisvenda(CanalVenda canaisvenda) {
		this.canaisvenda = canaisvenda;
	}

	public Cfop getCfopBean() {
		return this.cfopBean;
	}

	public void setCfopBean(Cfop cfopBean) {
		this.cfopBean = cfopBean;
	}

	public Cofins getCofin() {
		return this.cofin;
	}

	public void setCofin(Cofins cofin) {
		this.cofin = cofin;
	}

	public DocumentoFiscal getDocumentosfiscai() {
		return this.documentosfiscai;
	}

	public void setDocumentosfiscai(DocumentoFiscal documentosfiscai) {
		this.documentosfiscai = documentosfiscai;
	}

	public Icms getIcm() {
		return this.icm;
	}

	public void setIcm(Icms icm) {
		this.icm = icm;
	}

	public ImpostoImportacao getImpostoimportacao() {
		return this.impostoimportacao;
	}

	public void setImpostoimportacao(ImpostoImportacao impostoimportacao) {
		this.impostoimportacao = impostoimportacao;
	}

	public Inss getInssBean() {
		return this.inssBean;
	}

	public void setInssBean(Inss inssBean) {
		this.inssBean = inssBean;
	}

	public Ipi getIpiBean() {
		return this.ipiBean;
	}

	public void setIpiBean(Ipi ipiBean) {
		this.ipiBean = ipiBean;
	}

	public Iss getIssBean() {
		return this.issBean;
	}

	public void setIssBean(Iss issBean) {
		this.issBean = issBean;
	}

	public Mensagem getMensagen() {
		return this.mensagen;
	}

	public void setMensagen(Mensagem mensagen) {
		this.mensagen = mensagen;
	}

	public Mercado getMercadoBean() {
		return this.mercadoBean;
	}

	public void setMercadoBean(Mercado mercadoBean) {
		this.mercadoBean = mercadoBean;
	}

	public Pis getPi() {
		return this.pi;
	}

	public void setPi(Pis pi) {
		this.pi = pi;
	}

	public TipoNatureza getTiposnatureza() {
		return this.tiposnatureza;
	}

	public void setTiposnatureza(TipoNatureza tiposnatureza) {
		this.tiposnatureza = tiposnatureza;
	}

}