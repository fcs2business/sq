package br.com.bestsmart.smartquote.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Credencial;
import br.com.bestsmart.smartquote.model.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	List<Perfil> findByCredencial(Credencial credencial);
}
