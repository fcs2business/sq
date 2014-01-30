package br.com.bestsmart.smartquote.business.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.bestsmart.smartquote.business.EmpresaBs;
import br.com.bestsmart.smartquote.business.UsuarioBs;
import br.com.bestsmart.smartquote.business.WorkspaceBs;
import br.com.bestsmart.smartquote.business.WorkspaceBs.HierarchicalMenu;
import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.entity.Menu;
import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.model.entity.Usuario;
import br.com.bestsmart.smartquote.model.repository.PermissaoRepository;
import br.com.bestsmart.smartquote.test.AbstractSpringTest;

public class WorkspaceBsTest extends AbstractSpringTest {

	@Autowired
	private WorkspaceBs workspaceBs;

	@Autowired
	private EmpresaBs empresaBs;

	@Autowired
	private PermissaoRepository permissoesRepository;

	@Autowired
	private UsuarioBs usuarioBs;

	@Test
	public void successWhenAddNewMenu() throws Exception {
		Menu m = new Menu();
		m.setNome("Menu Teste");
		workspaceBs.add(m);
		assertTrue("O Id de um Menu existente no banco de dados deve ser maior ou igual a 0", m.getId() > 0);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void failsWhenTheMenuNameIsNull() throws Exception {
		workspaceBs.add(new Menu());
	}

	@Test
	public void successWhenAddASubmenu() throws Exception {
		Menu m = new Menu();
		m.setNome("Menu pai");
		Menu subMenu = new Menu();
		subMenu.setNome("Submenu");
		Menu menu = workspaceBs.addSubmenu(m, subMenu);
		assertNotNull(menu.getMenus());
		assertFalse(menu.getMenus().isEmpty());
		assertEquals(menu.getMenus().iterator().next(), subMenu);
	}

	@Test
	public void successWhenGetMenuByPerfil() throws Exception {
		Usuario newUsuario = newUsuario();
		Iterator<Credencial> credenciais = newUsuario.getCredenciais().iterator();
		Credencial next = credenciais.next();
		Perfil perfil = next.getPerfis().iterator().next();
		Set<HierarchicalMenu> menusByPermission = workspaceBs.getHierarchicalMenusByPerfil(perfil);
		assertNotNull(menusByPermission);
		assertFalse(menusByPermission.isEmpty());
	}

	@Test
	public void successWhenGetMenuByPerfilWhitNonAdminPerfilWhitoutPermissoes() throws Exception {
		Perfil perfil = usuarioBs.getPerfil(0);
		Set<HierarchicalMenu> menusByPermission = workspaceBs.getHierarchicalMenusByPerfil(perfil);
		assertNotNull(menusByPermission);
		assertTrue(menusByPermission.isEmpty());
	}

	@Test
	public void successWhenGetMenuByPerfilWhitNonAdminPerfil() throws Exception {
		Perfil perfil = usuarioBs.getPerfil(2);
		Set<HierarchicalMenu> menusByPermission = workspaceBs.getHierarchicalMenusByPerfil(perfil);
		assertNotNull(menusByPermission);
		assertFalse(menusByPermission.isEmpty());
	}

	@Test
	public void getHierarquicalMenusByPerfilReturnsEmptySetWhenPerfilIsNull() throws Exception {
		Set<HierarchicalMenu> menusByPermission = workspaceBs.getHierarchicalMenusByPerfil(null);
		assertNotNull(menusByPermission);

		assertTrue(menusByPermission.isEmpty());
	}

	@Test
	public void successWhenConfigureStartup() throws Exception {
		List<Menu> menus = workspaceBs.firstConfig();
		assertNotNull(menus);
		assertFalse(menus.isEmpty());
	}

	private Usuario newUsuario() {
		return null;
		// return usuarioBs.firstConfig();
	}
}
