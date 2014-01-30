package br.com.bestsmart.smartquote.model.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	List<Menu> findByNome(String nome);

	List<Menu> findAllByUrlNotNullOrderByIdAsc();

	List<Menu> findByPermissoesIn(@SuppressWarnings("rawtypes") Set permissao);
}
