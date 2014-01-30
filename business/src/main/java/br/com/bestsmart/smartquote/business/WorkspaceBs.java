package br.com.bestsmart.smartquote.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.bestsmart.smartquote.model.entity.Menu;
import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.model.entity.Permissao;
import br.com.bestsmart.smartquote.model.repository.CredencialRepository;
import br.com.bestsmart.smartquote.model.repository.MenuRepository;

@Component
public class WorkspaceBs {
	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private CredencialRepository credencialRepository;

	/**
	 * Save or update a menu
	 * 
	 * @param menu
	 * @return
	 */
	public Menu add(Menu menu) {
		return menuRepository.save(menu);
	}

	/**
	 * add a menu as child to an indicated father
	 * if the father does not exists this method will create it
	 * if the child does not exists this method will create it
	 * 
	 * @param father
	 * @param child
	 * @return the father
	 */
	public Menu addSubmenu(Menu father, Menu child) {
		father.addMenu(child);
		menuRepository.save(child);
		return menuRepository.save(father);
	}

	private Set<HierarchicalMenu> organizeHierarchically(List<Menu> menus) {
		List<HierarchicalMenu> hierarchical = new ArrayList<HierarchicalMenu>();
		for (Menu menu : menus) {
			menuExtractor(hierarchical, menu);
		}
		return new HashSet<WorkspaceBs.HierarchicalMenu>(hierarchical);
	}

	private void menuExtractor(List<HierarchicalMenu> list, Menu menu) {
		HierarchicalMenu hMenu = new HierarchicalMenu(menu.getId(), menu.getNome(), menu.getIcone(), menu.getUrl());
		Menu father = menu.getMenu();
		if (father == null) {
			if (!list.contains(hMenu)) {
				list.add(hMenu);
			}
		} else {
			if (list.contains(hMenu)) {
				int index = list.indexOf(hMenu);
				hMenu = list.remove(index);
			}
			HierarchicalMenu hFather = new HierarchicalMenu(father.getId(), father.getNome(), father.getIcone(), father.getUrl());
			if (list.contains(hFather)) {
				int index = list.indexOf(hFather);
				hFather = list.get(index);
				hFather.getChildren().add(hMenu);
			} else {
				if (!deepSearch(list, hFather, hMenu)) {
					hFather.getChildren().add(hMenu);
					list.add(hFather);
				}
			}
			menuExtractor(list, father);
		}
	}

	public boolean deepSearch(List<HierarchicalMenu> list, HierarchicalMenu father, HierarchicalMenu child) {
		if (list.contains(father)) {
			int index = list.indexOf(father);
			father = list.get(index);
			father.getChildren().add(child);
			return true;
		}
		for (HierarchicalMenu hierarchicalMenu : list) {
			if (deepSearch(new ArrayList<WorkspaceBs.HierarchicalMenu>(hierarchicalMenu.getChildren()), father, child)) {
				return true;
			}
		}
		return false;

	}

	public class HierarchicalMenu {
		private String icone;
		private String nome;
		private String url;
		private int id;
		private HierarchicalMenu father;
		private Set<HierarchicalMenu> children;

		public HierarchicalMenu(int id, String nome, String icone, String url) {
			this.children = new HashSet<WorkspaceBs.HierarchicalMenu>();
			this.id = id;
			this.icone = icone;
			this.nome = nome;
			this.url = url;
		}

		public String getUrl() {
			return url;
		}

		public String getIcone() {
			return icone;
		}

		public String getNome() {
			return nome;
		}

		public HierarchicalMenu getFather() {
			return father;
		}

		public Set<HierarchicalMenu> getChildren() {
			return children;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HierarchicalMenu other = (HierarchicalMenu) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		private WorkspaceBs getOuterType() {
			return WorkspaceBs.this;
		}
	}

	public Set<HierarchicalMenu> getHierarchicalMenusByPerfil(Perfil perfil) {
		if (perfil == null) {
			return new HashSet<WorkspaceBs.HierarchicalMenu>();
		}
		if (perfil.getPapel().isAdmin()) {
			return organizeHierarchically(allMenus());
		}
		Set<Permissao> permissoes = perfil.getPapel().getPermissoes();

		if (CollectionUtils.isEmpty(permissoes)) {
			return new HashSet<HierarchicalMenu>();
		}
		return organizeHierarchically(menuRepository.findByPermissoesIn(permissoes));
	}

	@Transactional
	public List<Menu> firstConfig() {
		long count = menuRepository.count();
		if (count == 0) {
			createMenus();
		}
		return menuRepository.findAll();

	}

	private void createMenus() {
		Menu m = newMenu("Administração", null, null, "fa fa-windows");
		Menu sub = newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Empresas", sub, "#/empresa", "icon- fa-building-o");
		newMenu("Usuários", sub,
				"#/usuario", "icon-fa fa-user");
		newMenu("Trocar Senha", sub,
				"#/alterarSenha", "icon-fa fa-pencil");

		newMenu("Conf. Email", sub,
				"#/email", "fa fa-envelope");

		Menu menuPai = null;
		m = newMenu("Ativo Fixo", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Compras", menuPai, null, "fa fa-folder");

		Menu subMenu = newMenu("Manutenção", m, null, "fa fa-folder");

		newMenu("Departamentos", subMenu,
				"#/departamento", "fa fa-group");
		newMenu("Natureza", subMenu,
				"#/natureza", "fa fa-group");

		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Vendas", menuPai,
				null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Estoque/Custo",
				menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Faturamento", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Financeiro", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Gestão Pessoal", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Livros Fiscais", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("P.C.P.", menuPai,
				null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Controle de Lojas",
				menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Call Center", menuPai, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Ponto Eletrônico", m, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");

		m = newMenu("Funcionários", m, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");

		m = newMenu("Relatórios", m, null, "fa fa-folder");

		newMenu("Manutenção", m,
				null, "fa fa-folder");
		newMenu("Movimentação", m,
				null, "fa fa-folder");
		newMenu("Consultas", m,
				null, "fa fa-folder");
		newMenu("Relatórios", m,
				null, "fa fa-folder");
	}

	private Menu newMenu(String nome, Menu menuPai, String url, String icone) {
		Menu menu = new Menu();
		menu.setNome(nome);
		menu.setUrl(url);
		if (menuPai != null) {
			menuPai.addMenu(menu);
		}
		menu.setIcone(icone);
		return menuRepository.save(menu);
	}

	public List<Menu> allMenus() {
		return menuRepository.findAllByUrlNotNullOrderByIdAsc();
	}

	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public CredencialRepository getCredencialRepository() {
		return credencialRepository;
	}

	public void setCredencialRepository(CredencialRepository credencialRepository) {
		this.credencialRepository = credencialRepository;
	}

}
