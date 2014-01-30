package br.com.bestsmart.smartquote.view.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bestsmart.smartquote.business.EmpresaBs;
import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.test.AbstractSpringTest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmpresaCtrlTest extends AbstractSpringTest {
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private EmpresaBs empresaBs;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void successWhenAddNewEmpresa() throws Exception {
		Empresa empresa = null;

		empresa.setId(-1);
		empresa.setCnpj("98877665443321");

		mockMvc.perform(post("/empresa/add").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(empresa)))
				.andExpect(status().isOk());
	}

}
