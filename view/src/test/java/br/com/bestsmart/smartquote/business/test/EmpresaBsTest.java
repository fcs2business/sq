package br.com.bestsmart.smartquote.business.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import br.com.bestsmart.smartquote.business.EmpresaBs;
import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.model.entity.Endereco;
import br.com.bestsmart.smartquote.model.entity.Telefone;
import br.com.bestsmart.smartquote.model.repository.EmpresaRepository;
import br.com.bestsmart.smartquote.model.repository.EnderecoRepository;
import br.com.bestsmart.smartquote.model.repository.ParametroGlobalRepository;
import br.com.bestsmart.smartquote.model.repository.TelefoneRepository;
import br.com.bestsmart.smartquote.test.AbstractSpringTest;

public class EmpresaBsTest extends AbstractSpringTest {

	private EmpresaBs empresaBs;
	private Empresa empresa;

	@Before
	public void setup() {
		EmpresaRepository empresaRepository = createMock(EmpresaRepository.class);
		EnderecoRepository enderecoRepository = createMock(EnderecoRepository.class);
		TelefoneRepository telefoneRepository = createMock(TelefoneRepository.class);
		ParametroGlobalRepository parametroGlobalRepository = createMock(ParametroGlobalRepository.class);

		expect(empresaRepository.count()).andReturn(0l).times(1);
		empresa = createMock(Empresa.class);
		expect(empresa.getTelefones()).andReturn(new HashSet<Telefone>());
		HashSet<Endereco> enderecos = new HashSet<Endereco>();
		expect(empresa.getEnderecos()).andReturn(enderecos).anyTimes();
		expect(empresaRepository.save(empresa)).andReturn(empresa);
		expect(enderecoRepository.save(enderecos)).andReturn(new ArrayList<Endereco>(enderecos));

		replay(empresaRepository, enderecoRepository, telefoneRepository, parametroGlobalRepository, empresa);
		empresaBs = new EmpresaBs(empresaRepository, telefoneRepository, enderecoRepository);
	}

	@Test
	public void successWhenAddNewEmpresa() throws Exception {
		empresaBs.addOrUpdate(empresa);
	}
}
