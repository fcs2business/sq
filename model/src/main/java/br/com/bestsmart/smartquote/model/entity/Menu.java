package br.com.bestsmart.smartquote.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name = "menus")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(length = 100)
	private String icone;

	@Column(nullable = false, length = 20)
	private String nome;

	@Column(length = 200)
	private String url;

	// bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name = "menuPai")
	@JsonBackReference
	private Menu menu;

	// bi-directional many-to-one association to Menu
	@OneToMany(mappedBy = "menu")
	@JsonManagedReference
	private Set<Menu> menus = new HashSet<Menu>();

	// bi-directional many-to-one association to Permissao
	@OneToMany(mappedBy = "menu")
	private Set<Permissao> permissoes = new HashSet<Permissao>();

	public Menu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcone() {
		return this.icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenu(Menu menu) {
		getMenus().add(menu);
		menu.setMenu(this);

		return menu;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setMenu(null);

		return menus;
	}

	public Set<Permissao> getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public Permissao addPermissao(Permissao permissao) {
		getPermissoes().add(permissao);
		permissao.setMenu(this);
		return permissao;
	}

	public Permissao removePermissao(Permissao permissao) {
		getPermissoes().remove(permissao);
		permissao.setMenu(null);

		return permissao;
	}

}
