package br.com.bestsmart.smartquote.view.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.bestsmart.smartquote.business.UsuarioBs;
import br.com.bestsmart.smartquote.model.entity.Perfil;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UsuarioBs usuarioBs;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		response.setHeader("content-type", "application/json");
		response.setHeader("accept", "application/json");
		if (authentication != null && authentication.isAuthenticated()) {
			PrintWriter writer = response.getWriter();
			CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
			writer.write(new ObjectMapper().writeValueAsString(PerfilToUser.from(usuarioBs.getPerfilsByCredencial(userDetail.getCredencial()))));
			writer.flush();
		}
	}

	public static class PerfilToUser {
		private int perfilId;
		private int empresaId;
		private String empresa;

		private int papelId;
		private String papel;

		public PerfilToUser(int perfilId, int empresaId, String empresa, int papelId, String papel) {
			super();
			this.perfilId = perfilId;
			this.empresaId = empresaId;
			this.empresa = empresa;
			this.papelId = papelId;
			this.papel = papel;
		}

		public int getPerfilId() {
			return perfilId;
		}

		public void setPerfilId(int perfilId) {
			this.perfilId = perfilId;
		}

		public static List<PerfilToUser> from(List<Perfil> perfis) {
			List<PerfilToUser> result = new ArrayList<RestAuthenticationSuccessHandler.PerfilToUser>();
			for (Perfil perfil : perfis) {
				result.add(new PerfilToUser(perfil.getId(), perfil.getEmpresa().getId(), perfil.getEmpresa().getNomeFantasia(), perfil.getPapel().getId(), perfil.getPapel().getDescricao()));
			}
			return result;
		}

		public int getEmpresaId() {
			return empresaId;
		}

		public void setEmpresaId(int empresaId) {
			this.empresaId = empresaId;
		}

		public String getEmpresa() {
			return empresa;
		}

		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}

		public int getPapelId() {
			return papelId;
		}

		public void setPapelId(int papelId) {
			this.papelId = papelId;
		}

		public String getPapel() {
			return papel;
		}

		public void setPapel(String papel) {
			this.papel = papel;
		}

	}
}
