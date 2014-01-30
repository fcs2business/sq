package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the codvinculacoes database table.
 * 
 */
@Entity
@Table(name="codvinculacoes")
@NamedQuery(name="CodVinculacao.findAll", query="SELECT c FROM CodVinculacao c")
public class CodVinculacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	public CodVinculacao() {
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

}