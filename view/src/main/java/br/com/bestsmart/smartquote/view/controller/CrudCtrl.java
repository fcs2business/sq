package br.com.bestsmart.smartquote.view.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.bestsmart.smartquote.view.controller.exception.ControllerException;

public interface CrudCtrl<T> {
	String add(T instance) throws ControllerException;

	String update(T instance) throws ControllerException;

	String remove(T instance) throws ControllerException;

	Page<T> list(PageRequest pageRequest) throws ControllerException;
}
