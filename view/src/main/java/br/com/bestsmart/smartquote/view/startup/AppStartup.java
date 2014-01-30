package br.com.bestsmart.smartquote.view.startup;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.bestsmart.smartquote.business.EmpresaBs;
import br.com.bestsmart.smartquote.business.UsuarioBs;
import br.com.bestsmart.smartquote.business.WorkspaceBs;
import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.model.entity.Endereco;
import br.com.bestsmart.smartquote.model.entity.ParametroGlobal;
import br.com.bestsmart.smartquote.model.entity.Telefone;

@Component
public class AppStartup {
	private static final String SERVIDOR_EMAIL_SMTP_STARTTLS_ENABLE = "servidor.email.smtp.starttls.enable";

	private static final String SERVIDOR_EMAIL_SMTP_AUTH = "servidor.email.smtp.auth";

	private static final String SERVIDOR_EMAIL_PROTOCOL = "servidor.email.protocol";

	private static final String SERVIDOR_EMAIL_HOST_PORT = "servidor.email.host.port";

	private static final String SERVIDOR_EMAIL_SENHA = "servidor.email.senha";

	private static final String SERVIDOR_EMAIL_USUARIO = "servidor.email.usuario";

	private static final String SERVIDOR_EMAIL_HOST = "servidor.email.host";

	private static final String SERVIDOR_EMAIL_ENCODING = "servidor.email.encoding";

	@Autowired
	private EmpresaBs empresaBs;

	@Autowired
	private UsuarioBs usuarioBs;

	@Autowired
	private WorkspaceBs workspaceBs;

	@PostConstruct
	@Transactional
	public void configure() {
		// usuarioBs.firstConfig();
		workspaceBs.firstConfig();
	}

	@Transactional
	public Empresa firstConfig() {
		// long count = empresaRepository.count();
		// if (count > 0) {
		// return empresaRepository.findAll().get(0);
		// }
		//
		// Endereco endereco = createFirstEndereco();
		//
		// Telefone telefone = createFirstTelefone();
		//
		// Empresa empresa = createFirstEmpresa();
		//
		// empresa = add(empresa);
		//
		// telefone.getEmpresas().add(empresa);
		// telefone = telefoneRepository.save(telefone);
		//
		// endereco.getEmpresas().add(empresa);
		// endereco = enderecoRepository.save(endereco);
		//
		// parametroGlobalRepository.save(configureEmailParams(empresa));
		// return empresa;
		return null;

	}

	public Endereco createFirstEndereco() {
		Endereco endereco = new Endereco();
		endereco.setDescricao("Principal");
		endereco.setCep("75043044");
		endereco.setRua("Av. Tiradentes");
		endereco.setNumero("1193");
		endereco.setBairro("Centro");
		endereco.setCidade("Anápolis");
		endereco.setEstado("Goiás");
		endereco.setReferencia("Alfa Informática e Igreja Assembéia de Deus Madureira");
		return endereco;
	}

	public Telefone createFirstTelefone() {
		Telefone telefone = new Telefone();
		telefone.setDescricao("Principal");
		telefone.setDdd("062");
		telefone.setNumero("92074331");
		return telefone;
	}

	public Empresa createFirstEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("17217985000104");
		empresa.setNomeFantasia("Best Smart");
		empresa.setRazaoSocial("BestSmart");
		empresa.setInscricaoEstadual("100548776");
		empresa.setCodigo("001");
		empresa.setCodigoNire("00052");
		empresa.setInscricaoMunicipal("4161620011");
		empresa.setCodigoIbge("5208707");
		return empresa;
	}

	private List<ParametroGlobal> configureEmailParams(Empresa empresa) {
		List<ParametroGlobal> params = new ArrayList<ParametroGlobal>();

		/*
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_ENCODING) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_ENCODING,
		 * "UTF-8"));
		 * 
		 * }
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_HOST) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_HOST,
		 * "smtp.gmail.com"));
		 * }
		 * 
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_USUARIO) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_USUARIO,
		 * "fshego@gmail.com"));
		 * }
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_SENHA) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_SENHA,
		 * "RasenShuriken339"));
		 * }
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_HOST_PORT) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_HOST_PORT,
		 * "465"));
		 * }
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_PROTOCOL) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_PROTOCOL,
		 * "smtp"));
		 * }
		 * 
		 * if (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_SMTP_AUTH) ==
		 * null) {
		 * params.add(newParametroGlobal(empresa, SERVIDOR_EMAIL_SMTP_AUTH,
		 * "true"));
		 * }
		 * if
		 * (parametroGlobalRepository.findByName(SERVIDOR_EMAIL_SMTP_STARTTLS_ENABLE
		 * ) == null) {
		 * params.add(newParametroGlobal(empresa,
		 * SERVIDOR_EMAIL_SMTP_STARTTLS_ENABLE, "true"));
		 * }
		 */
		return params;
	}

	private ParametroGlobal newParametroGlobal(Empresa empresa, String name, String value) {
		ParametroGlobal parametroGlobal = new ParametroGlobal();
		parametroGlobal.setName(name);
		parametroGlobal.setValue(value);
		parametroGlobal.setEmpresa(empresa);
		return parametroGlobal;
	}

}
