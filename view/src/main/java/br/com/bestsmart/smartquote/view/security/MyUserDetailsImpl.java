package br.com.bestsmart.smartquote.view.security;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.repository.CredencialRepository;
import br.com.bestsmart.smartquote.model.repository.PermissaoRepository;

@Repository
public class MyUserDetailsImpl implements UserDetailsService {

	@Autowired
	private CredencialRepository credenciaisRepository;
	@Autowired
	private PermissaoRepository permissoesRepository;

	@Autowired
	private MessageSource messageSource;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Credencial credencial = credenciaisRepository.findByLogin(username);
		if (credencial == null) {
			throw new BadCredentialsException(messageSource.getMessage("PasswordComparisonAuthenticator.badCredentials", new Object[] { username }, Locale.getDefault()));
		}
		return new CustomUserDetail(permissoesRepository, credencial, null);
	}

}
