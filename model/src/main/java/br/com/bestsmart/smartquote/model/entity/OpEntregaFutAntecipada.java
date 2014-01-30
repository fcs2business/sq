package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the opentregasfutantecipadas database table.
 * 
 */
@Entity
@Table(name="opentregasfutantecipadas")
@NamedQuery(name="OpEntregaFutAntecipada.findAll", query="SELECT o FROM OpEntregaFutAntecipada o")
public class OpEntregaFutAntecipada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	//bi-directional many-to-one association to Atualizacao
	@OneToMany(mappedBy="opentregasfutantecipada")
	private Set<Atualizacao> atualizacoes;

	public OpEntregaFutAntecipada() {
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

	public Set<Atualizacao> getAtualizacoes() {
		return this.atualizacoes;
	}

	public void setAtualizacoes(Set<Atualizacao> atualizacoes) {
		this.atualizacoes = atualizacoes;
	}

	public Atualizacao addAtualizacoe(Atualizacao atualizacoe) {
		getAtualizacoes().add(atualizacoe);
		atualizacoe.setOpentregasfutantecipada(this);

		return atualizacoe;
	}

	public Atualizacao removeAtualizacoe(Atualizacao atualizacoe) {
		getAtualizacoes().remove(atualizacoe);
		atualizacoe.setOpentregasfutantecipada(null);

		return atualizacoe;
	}

}