package br.com.bestsmart.smartquote.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bestsmart.smartquote.business.EmpresaBs;
import br.com.bestsmart.smartquote.model.entity.Empresa;

@Controller
@RequestMapping(value = "/empresa")
public class EmpresaCtrl {

	@Autowired
	private EmpresaBs empresaBs;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/add")
	public @ResponseBody
	String add(@RequestBody Empresa empresa) {
		empresaBs.addOrUpdate(empresa);
		return "sucesso!";
	}
}
