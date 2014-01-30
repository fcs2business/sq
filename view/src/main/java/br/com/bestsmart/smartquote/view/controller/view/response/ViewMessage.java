package br.com.bestsmart.smartquote.view.controller.view.response;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ViewMessage {

	@Autowired
	private MessageSource messageSource;

	public ViewMessage() {
	}

	public String answerWith(String msgKey, Object[] values) {
		return (messageSource.getMessage(msgKey, values, Locale.getDefault()));
	}

	public String answerWith(String msgKey) {
		return (messageSource.getMessage(msgKey, new Object[0], Locale.getDefault()));
	}
}
