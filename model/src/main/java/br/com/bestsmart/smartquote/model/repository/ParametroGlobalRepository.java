package br.com.bestsmart.smartquote.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Empresa;
import br.com.bestsmart.smartquote.model.entity.ParametroGlobal;

public interface ParametroGlobalRepository extends JpaRepository<ParametroGlobal, Integer> {
	ParametroGlobal findByName(String name);

	List<ParametroGlobal> findByEmpresa(Empresa empresa);
}
