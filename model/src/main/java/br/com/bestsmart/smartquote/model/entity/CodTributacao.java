package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the codtributacoes database table.
 * 
 */
@Entity
@Table(name = "codtributacoes")
@NamedQuery(name = "CodTributacao.findAll", query = "SELECT c FROM CodTributacao c")
public class CodTributacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 255)
	private String descricao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	public CodTributacao() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
