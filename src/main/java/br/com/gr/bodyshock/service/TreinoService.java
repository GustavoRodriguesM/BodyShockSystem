package br.com.gr.bodyshock.service;

import java.util.List;

import br.com.gr.bodyshock.model.Treino;

public interface TreinoService extends AbstractService<Treino, String> {
	List<String> findAllIds();

	List<Treino> findAllWithoutDefault();
}
