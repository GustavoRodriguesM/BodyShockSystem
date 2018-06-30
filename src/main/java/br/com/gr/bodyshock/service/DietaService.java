package br.com.gr.bodyshock.service;

import java.util.List;

import br.com.gr.bodyshock.model.Dieta;

public interface DietaService extends AbstractService<Dieta, String> {
	List<String> findAllIds();

	List<Dieta> findAllWithoutDefault();
}
