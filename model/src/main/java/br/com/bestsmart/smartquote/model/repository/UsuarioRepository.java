package br.com.bestsmart.smartquote.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByCpf(String cpf);

	List<Usuario> findByCredenciaisPerfisPapelAdminIsTrue();
}
