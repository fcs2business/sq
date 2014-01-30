package br.com.bestsmart.smartquote.view.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import br.com.bestsmart.smartquote.model.repository.MenuRepository;
import br.com.bestsmart.smartquote.security.LoginTestService;

public class UsuarioCtrlTest extends LoginTestService {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	private MenuRepository repository;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(this.wac).build();
		super.adminLogin();
	}

	@Test
	public void successWhenGetListOfProfiles() throws Exception {
		mockMvc.perform(get("/usuario/listPerfis"))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void successWhenEntrar() throws Exception {
		mockMvc.perform(get("/usuario/entrar/1"))
				.andExpect(status().isOk()).andExpect(content().string("sucesso"));
	}

	@Test(expected = NestedServletException.class)
	public void failWhenPerfilDoesNotExist() throws Exception {
		mockMvc.perform(get("/usuario/entrar/-1"));
	}

}
