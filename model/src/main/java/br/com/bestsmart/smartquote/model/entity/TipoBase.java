package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tiposbase database table.
 * 
 */
@Entity
@Table(name="tiposbase")
@NamedQuery(name="TipoBase.findAll", query="SELECT t FROM TipoBase t")
public class TipoBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String descricao;

	//bi-directional many-to-one association to Ipi
	@OneToMany(mappedBy="tiposbase")
	private Set<Ipi> ipis;

	//bi-directional many-to-one association to Iss
	@OneToMany(mappedBy="tiposbase")
	private Set<Iss> isses;

	public TipoBase() {
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

	public Set<Ipi> getIpis() {
		return this.ipis;
	}

	public void setIpis(Set<Ipi> ipis) {
		this.ipis = ipis;
	}

	public Ipi addIpi(Ipi ipi) {
		getIpis().add(ipi);
		ipi.setTiposbase(this);

		return ipi;
	}

	public Ipi removeIpi(Ipi ipi) {
		getIpis().remove(ipi);
		ipi.setTiposbase(null);

		return ipi;
	}

	public Set<Iss> getIsses() {
		return this.isses;
	}

	public void setIsses(Set<Iss> isses) {
		this.isses = isses;
	}

	public Iss addIss(Iss iss) {
		getIsses().add(iss);
		iss.setTiposbase(this);

		return iss;
	}

	public Iss removeIss(Iss iss) {
		getIsses().remove(iss);
		iss.setTiposbase(null);

		return iss;
	}

}