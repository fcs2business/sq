package br.com.bestsmart.smartquote.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.bestsmart.smartquote.business.UsuarioBs;
import br.com.bestsmart.smartquote.test.AbstractSpringTest;
import br.com.bestsmart.smartquote.view.security.CustomUserDetail;
import br.com.bestsmart.smartquote.view.security.MyUserDetailsImpl;

public abstract class LoginTestService extends AbstractSpringTest {
	@Autowired
	private UsuarioBs usuarioBs;

	@Autowired
	private MyUserDetailsImpl mudi;

	public void adminLogin() {
		// usuarioBs.firstConfig();
		CustomUserDetail userDetails = (CustomUserDetail) mudi.loadUserByUsername("admin");
		userDetails.setPerfil(usuarioBs.getPerfil(1));
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	public void supervisorLogin() {
		// usuarioBs.firstConfig();
		CustomUserDetail userDetails = (CustomUserDetail) mudi.loadUserByUsername("admin");
		userDetails.setPerfil(usuarioBs.getPerfil(0));
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}
}
