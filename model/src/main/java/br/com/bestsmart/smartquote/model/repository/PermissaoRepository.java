package br.com.bestsmart.smartquote.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Papel;
import br.com.bestsmart.smartquote.model.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
	List<Permissao> findByPapel(Papel papel);
}
