package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the mensagens database table.
 * 
 */
@Entity
@Table(name="mensagens")
@NamedQuery(name="Mensagem.findAll", query="SELECT m FROM Mensagem m")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	//bi-directional many-to-one association to DocumentoFiscal
	@OneToMany(mappedBy="mensagen")
	private Set<DocumentoFiscal> documentosfiscais;

	//bi-directional many-to-one association to NaturezaOperacao
	@OneToMany(mappedBy="mensagen")
	private Set<NaturezaOperacao> naturezasoperacoes;

	public Mensagem() {
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

	public Set<DocumentoFiscal> getDocumentosfiscais() {
		return this.documentosfiscais;
	}

	public void setDocumentosfiscais(Set<DocumentoFiscal> documentosfiscais) {
		this.documentosfiscais = documentosfiscais;
	}

	public DocumentoFiscal addDocumentosfiscai(DocumentoFiscal documentosfiscai) {
		getDocumentosfiscais().add(documentosfiscai);
		documentosfiscai.setMensagen(this);

		return documentosfiscai;
	}

	public DocumentoFiscal removeDocumentosfiscai(DocumentoFiscal documentosfiscai) {
		getDocumentosfiscais().remove(documentosfiscai);
		documentosfiscai.setMensagen(null);

		return documentosfiscai;
	}

	public Set<NaturezaOperacao> getNaturezasoperacoes() {
		return this.naturezasoperacoes;
	}

	public void setNaturezasoperacoes(Set<NaturezaOperacao> naturezasoperacoes) {
		this.naturezasoperacoes = naturezasoperacoes;
	}

	public NaturezaOperacao addNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().add(naturezasoperacoe);
		naturezasoperacoe.setMensagen(this);

		return naturezasoperacoe;
	}

	public NaturezaOperacao removeNaturezasoperacoe(NaturezaOperacao naturezasoperacoe) {
		getNaturezasoperacoes().remove(naturezasoperacoe);
		naturezasoperacoe.setMensagen(null);

		return naturezasoperacoe;
	}

}