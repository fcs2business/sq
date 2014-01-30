package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the basesicms database table.
 * 
 */
@Entity
@Table(name="basesicms")
@NamedQuery(name="BasesIcms.findAll", query="SELECT b FROM BasesIcms b")
public class BasesIcms implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	//bi-directional many-to-one association to Icms
	@OneToMany(mappedBy="basesicm")
	private Set<Icms> icms;

	public BasesIcms() {
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

	public Set<Icms> getIcms() {
		return this.icms;
	}

	public void setIcms(Set<Icms> icms) {
		this.icms = icms;
	}

	public Icms addIcm(Icms icm) {
		getIcms().add(icm);
		icm.setBasesicm(this);

		return icm;
	}

	public Icms removeIcm(Icms icm) {
		getIcms().remove(icm);
		icm.setBasesicm(null);

		return icm;
	}

}