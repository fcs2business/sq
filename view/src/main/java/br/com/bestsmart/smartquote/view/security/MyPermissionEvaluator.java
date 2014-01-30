package br.com.bestsmart.smartquote.view.security;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.model.repository.CredencialRepository;

public class MyPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private CredencialRepository credencialRepository;

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
		Perfil perfil = userDetail.getPerfil();
		if (perfil == null) {
			SecurityContextHolder.clearContext();
			return false;
		}
		if (perfil.getPapel().isAdmin()) {
			return true;
		}

		List<String> permissions = Arrays.asList(permission.toString().split(
				","));
		Collection<? extends GrantedAuthority> authorities = userDetail
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (permissions.contains(grantedAuthority.getAuthority())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		return false;
	}

}
