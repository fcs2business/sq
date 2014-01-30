package br.com.bestsmart.smartquote.view.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bestsmart.smartquote.model.repository.MenuRepository;
import br.com.bestsmart.smartquote.security.LoginTestService;

public class WorkspaceCtrlTest extends LoginTestService {

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
	public void successWhenGetListOfMenus() throws Exception {
		mockMvc.perform(get("/workspace/listMenus"))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$[0].nome").exists());

	}
}
