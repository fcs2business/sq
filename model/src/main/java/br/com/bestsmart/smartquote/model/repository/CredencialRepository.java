package br.com.bestsmart.smartquote.model.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.entity.Usuario;

public interface CredencialRepository extends JpaRepository<Credencial, Integer> {
	Credencial findByLoginAndSenha(String login, String senha);

	Credencial findByLogin(String login);

	List<Credencial> findByPerfisPapelAdminIsTrue();

	Set<Credencial> findByUsuario(Usuario usuario);
}
