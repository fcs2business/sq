package br.com.bestsmart.smartquote.view.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bestsmart.smartquote.business.UsuarioBs;
import br.com.bestsmart.smartquote.model.entity.Perfil;
import br.com.bestsmart.smartquote.view.controller.exception.ControllerException;
import br.com.bestsmart.smartquote.view.security.CustomUserDetail;

@Controller
@RequestMapping("/usuario")
public class UsuarioCtrl {

	@Autowired
	private UsuarioBs usuarioBs;

	@Autowired
	private ControllerException ctrlException;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/entrar/{id}")
	public @ResponseBody
	String entrar(@PathVariable("id") int id) {
		Perfil perfil = usuarioBs.getPerfil(id);
		CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (userDetail.getCredencial().getPerfis().contains(perfil)) {
			userDetail.setPerfil(perfil);
		} else {
			ctrlException.throwIt("JdbcDaoImpl.noAuthority", new Object[] { "'Sem perfil'" });
		}
		return "sucesso";
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/listPerfis")
	public Collection<Perfil> listPerfis() throws ControllerException {
		CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioBs.getPerfilsByCredencial(userDetail.getCredencial());

	}

}
