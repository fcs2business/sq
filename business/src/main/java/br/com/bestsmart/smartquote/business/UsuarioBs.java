package br.com.bestsmart.smartquote.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.model.entity.Papel;
import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.model.repository.CredencialRepository;
import br.com.bestsmart.smartquote.model.repository.EmpresaRepository;
import br.com.bestsmart.smartquote.model.repository.PapelRepository;
import br.com.bestsmart.smartquote.model.repository.PerfilRepository;
import br.com.bestsmart.smartquote.model.repository.PermissaoRepository;
import br.com.bestsmart.smartquote.model.repository.UsuarioRepository;

@Component
public class UsuarioBs {

	@Autowired
	private PermissaoRepository permissoesRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CredencialRepository credencialRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private WorkspaceBs workspaceBs;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private EmpresaBs empresaBs;

	@Autowired
	private PapelRepository papelRepository;

	/*
	 * @Transactional
	 * public Usuario firstConfig() {
	 * List<Credencial> credenciais =
	 * credencialRepository.findByPerfisPapelAdminIsTrue();
	 * if (CollectionUtils.isEmpty(credenciais)) {
	 * Credencial credencial = new Credencial();
	 * credencial.setLogin("admin");
	 * credencial.setEmail("fabriciodacunhasantos@gmail.com");
	 * credencial.setSenha(
	 * "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
	 * credencial.setBloqueado(false);
	 * 
	 * Papel papel = new Papel();
	 * papel.setAdmin(true);
	 * papel.setDescricao("Administrador");
	 * papel = papelRepository.save(papel);
	 * 
	 * Papel supervisor = new Papel();
	 * supervisor.setAdmin(false);
	 * supervisor.setDescricao("Supervisor");
	 * supervisor = papelRepository.save(supervisor);
	 * Papel comprador = new Papel();
	 * comprador.setAdmin(false);
	 * comprador.setDescricao("Supervisor");
	 * comprador = papelRepository.save(comprador);
	 * 
	 * Usuario usuario = new Usuario();
	 * 
	 * usuario.setNome("administrador");
	 * usuario.setCpf("02623805105");
	 * 
	 * usuario = usuarioRepository.save(usuario);
	 * 
	 * credencial.setUsuario(usuario);
	 * credencial = credencialRepository.save(credencial);
	 * Perfil perfil = newPerfil(credencial, empresaBs.firstConfig(), papel);
	 * Perfil perfilSup = newPerfil(credencial, empresaBs.firstConfig(),
	 * supervisor);
	 * Perfil perfilComprador = newPerfil(credencial, empresaBs.firstConfig(),
	 * comprador);
	 * 
	 * perfilRepository.save(perfilSup);
	 * perfilRepository.save(perfil);
	 * perfilRepository.save(perfilComprador);
	 * 
	 * List<Menu> menus = workspaceBs.firstConfig();
	 * for (Menu menu : menus) {
	 * Permissao permissao = new Permissao();
	 * permissao.setPapel(comprador);
	 * permissao.setLer(true);
	 * permissao.setMenu(menu);
	 * permissoesRepository.save(permissao);
	 * }
	 * credencial = credencialRepository.findOne(credencial.getId());
	 * usuario = usuarioRepository.findOne(usuario.getId());
	 * usuario.setCredenciais(credencialRepository.findByUsuario(usuario));
	 * return usuario;
	 * }
	 * Usuario usuario = credenciais.get(0).getUsuario();
	 * usuario.setCredenciais(credencialRepository.findByUsuario(usuario));
	 * return usuario;
	 * 
	 * }
	 */
	private Perfil newPerfil(Credencial credencial, Empresa empresa, Papel papel) {
		Perfil perfil = new Perfil();
		perfil.setCredencial(credencial);
		credencial.addPerfil(perfil);
		perfil.setEmpresa(empresa);
		perfil.setPapel(papel);
		return perfil;
	}

	public List<Perfil> getPerfilsByCredencial(Credencial credencial) {
		if (credencial == null) {
			return new ArrayList<Perfil>();
		}
		return perfilRepository.findByCredencial(credencial);
	}

	public Perfil getPerfil(int id) {
		return perfilRepository.findOne(id);
	}

	public PermissaoRepository getPermissoesRepository() {
		return permissoesRepository;
	}

	public void setPermissoesRepository(PermissaoRepository permissoesRepository) {
		this.permissoesRepository = permissoesRepository;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public CredencialRepository getCredencialRepository() {
		return credencialRepository;
	}

	public void setCredencialRepository(CredencialRepository credencialRepository) {
		this.credencialRepository = credencialRepository;
	}

	public EmpresaRepository getEmpresaRepository() {
		return empresaRepository;
	}

	public void setEmpresaRepository(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public WorkspaceBs getWorkspaceBs() {
		return workspaceBs;
	}

	public void setWorkspaceBs(WorkspaceBs workspaceBs) {
		this.workspaceBs = workspaceBs;
	}

	public PerfilRepository getPerfilRepository() {
		return perfilRepository;
	}

	public void setPerfilRepository(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	public EmpresaBs getEmpresaBs() {
		return empresaBs;
	}

	public void setEmpresaBs(EmpresaBs empresaBs) {
		this.empresaBs = empresaBs;
	}

	public PapelRepository getPapelRepository() {
		return papelRepository;
	}

	public void setPapelRepository(PapelRepository papelRepository) {
		this.papelRepository = papelRepository;
	}

}
