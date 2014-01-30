package br.com.bestsmart.smartquote.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bestsmart.smartquote.model.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
