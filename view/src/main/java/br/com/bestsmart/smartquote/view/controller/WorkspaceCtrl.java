package br.com.bestsmart.smartquote.view.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bestsmart.smartquote.business.WorkspaceBs;
import br.com.bestsmart.smartquote.business.WorkspaceBs.HierarchicalMenu;
import br.com.bestsmart.smartquote.view.security.CustomUserDetail;

@Controller
@RequestMapping("/workspace")
public class WorkspaceCtrl {

	@Autowired
	private WorkspaceBs workspaceBs;

	@PreAuthorize("hasPermission(#this,'MENU_READ')")
	@RequestMapping(value = "/listMenus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody
	Collection<HierarchicalMenu> listMenus() {
		CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return workspaceBs.getHierarchicalMenusByPerfil(userDetail.getPerfil());
	}
}
