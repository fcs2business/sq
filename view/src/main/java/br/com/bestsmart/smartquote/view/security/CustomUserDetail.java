package br.com.bestsmart.smartquote.view.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.entity.Menu;
import br.com.bestsmart.smartquote.model.entity.Papel;
import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.model.entity.Permissao;
import br.com.bestsmart.smartquote.model.repository.PermissaoRepository;

public class CustomUserDetail implements UserDetails {
	private static final long serialVersionUID = -1054256724845137632L;

	private PermissaoRepository permissoesRepository;

	private Credencial credencial;

	private Perfil perfil;

	public CustomUserDetail(PermissaoRepository permissoesRepository, Credencial credencial, Perfil perfil) {
		super();
		this.permissoesRepository = permissoesRepository;
		this.credencial = credencial;
		this.perfil = perfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	private List<GrantedAuthority> getAuthorities(Permissao permissao, Menu menu) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (StringUtils.hasText(menu.getUrl())) {
			String url = menu.getUrl().replaceAll("#/", "");
			if (permissao.isCriar()) {
				authorities.add(new SimpleGrantedAuthority(url + "_criar".toUpperCase()));
			} else {
				authorities.remove(new SimpleGrantedAuthority(url + "_criar".toUpperCase()));
			}
			if (permissao.isEditar()) {
				authorities.add(new SimpleGrantedAuthority(url + "_editar".toUpperCase()));
			} else {
				authorities.remove(new SimpleGrantedAuthority(url + "_editar".toUpperCase()));
			}
			if (permissao.isLer()) {
				authorities.add(new SimpleGrantedAuthority(url + "_ler".toUpperCase()));
			} else {
				authorities.remove(new SimpleGrantedAuthority(url + "_ler".toUpperCase()));
			}
			if (permissao.isRemover()) {
				authorities.add(new SimpleGrantedAuthority(url + "_remover".toUpperCase()));
			} else {
				authorities.remove(new SimpleGrantedAuthority(url + "_remover".toUpperCase()));
			}
		}
		for (Menu m : menu.getMenus()) {
			authorities.addAll(getAuthorities(permissao, m));
		}
		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (perfil == null) {
			return new ArrayList<GrantedAuthority>();
		}
		Papel papel = perfil.getPapel();
		List<Permissao> permissoes = permissoesRepository.findByPapel(papel);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Permissao permissao : permissoes) {
			authorities.addAll(getAuthorities(permissao, permissao.getMenu()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return credencial.getSenha();
	}

	@Override
	public String getUsername() {
		return credencial.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return isCredentialsNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !credencial.isBloqueado();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		Date dataExpiracao = credencial.getDataExpiracao();
		if (dataExpiracao == null) {
			return true;
		}
		return dataExpiracao.after(new Date());
	}

	@Override
	public boolean isEnabled() {
		return !credencial.isBloqueado();
	}

}
