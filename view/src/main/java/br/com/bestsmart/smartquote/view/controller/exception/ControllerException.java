package br.com.bestsmart.smartquote.view.controller.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Classes com mensagens amigáveis, que serão retornadas para os usuários
 * 
 * @author Fabrício
 * 
 */
@Component
public class ControllerException extends RuntimeException {

	private static final long serialVersionUID = -6075891199504225972L;

	@Autowired
	private MessageSource messageSource;

	public ControllerException() {
	}

	public void throwIt(String msgKey, Object[] values, Throwable t) {
		throw new InsufficientAuthenticationException(messageSource.getMessage(msgKey, values, Locale.getDefault()), t);
	}

	public void throwIt(String msgKey) {
		throw new InsufficientAuthenticationException(messageSource.getMessage(msgKey, new Object[0], Locale.getDefault()));
	}

	public void throwIt(String msgKey, Throwable t) {
		throw new InsufficientAuthenticationException(messageSource.getMessage(msgKey, new Object[0], Locale.getDefault()), t);
	}

	public void throwIt(String msgKey, Object[] values) {
		throw new InsufficientAuthenticationException(messageSource.getMessage(msgKey, values, Locale.getDefault()));
	}
}
