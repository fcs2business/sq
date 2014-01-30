package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the especiedocfiscal database table.
 * 
 */
@Entity
@Table(name="especiedocfiscal")
@NamedQuery(name="EspecieDocFiscal.findAll", query="SELECT e FROM EspecieDocFiscal e")
public class EspecieDocFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	//bi-directional many-to-one association to DocumentoFiscal
	@OneToMany(mappedBy="especiedocfiscal")
	private Set<DocumentoFiscal> documentosfiscais;

	public EspecieDocFiscal() {
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
		documentosfiscai.setEspeciedocfiscal(this);

		return documentosfiscai;
	}

	public DocumentoFiscal removeDocumentosfiscai(DocumentoFiscal documentosfiscai) {
		getDocumentosfiscais().remove(documentosfiscai);
		documentosfiscai.setEspeciedocfiscal(null);

		return documentosfiscai;
	}

}