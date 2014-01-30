package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the permissoes database table.
 * 
 */
@Entity
@Table(name = "permissoes")
@NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	private boolean criar;

	private boolean editar;

	private boolean ler;

	private boolean remover;

	// bi-directional many-to-one association to Credencial
	@ManyToOne
	@JoinColumn(name = "papel", nullable = false)
	private Papel papel;

	// bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name = "menu", nullable = false)
	private Menu menu;

	public Permissao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCriar() {
		return criar;
	}

	public void setCriar(boolean criar) {
		this.criar = criar;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public boolean isLer() {
		return ler;
	}

	public void setLer(boolean ler) {
		this.ler = ler;
	}

	public boolean isRemover() {
		return remover;
	}

	public void setRemover(boolean remover) {
		this.remover = remover;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
