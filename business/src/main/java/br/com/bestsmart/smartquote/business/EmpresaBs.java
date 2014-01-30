package br.com.bestsmart.smartquote.business;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.model.entity.Endereco;
import br.com.bestsmart.smartquote.model.entity.Telefone;
import br.com.bestsmart.smartquote.model.repository.EmpresaRepository;
import br.com.bestsmart.smartquote.model.repository.EnderecoRepository;
import br.com.bestsmart.smartquote.model.repository.TelefoneRepository;

@Component
public class EmpresaBs {

	private EmpresaRepository empresaRepository;
	private TelefoneRepository telefoneRepository;
	private EnderecoRepository enderecoRepository;

	@Autowired
	public EmpresaBs(EmpresaRepository empresaRepository, TelefoneRepository telefoneRepository, EnderecoRepository enderecoRepository) {
		this.empresaRepository = empresaRepository;
		this.telefoneRepository = telefoneRepository;
		this.enderecoRepository = enderecoRepository;
	}

	/**
	 * Adiciona uma empresa, garante que os telefones e endereços da empresa
	 * estejam devidamente salvos, caso já estiverem salvos eles serão
	 * atualizados.
	 * 
	 * @param empresa
	 * @return empresa salva no banco de dados
	 */
	public Empresa addOrUpdate(Empresa empresa) {
		if (empresa == null) {
			return null;
		}
		Set<Endereco> enderecos = empresa.getEnderecos();
		Set<Telefone> telefones = empresa.getTelefones();
		enderecoRepository.save(enderecos);
		telefoneRepository.save(telefones);
		return empresaRepository.save(empresa);
	}

}
