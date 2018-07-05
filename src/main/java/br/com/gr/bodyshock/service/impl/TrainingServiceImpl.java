package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Treino;
import br.com.gr.bodyshock.repository.TreinoRepository;
import br.com.gr.bodyshock.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TreinoRepository treinoRepository;

	@Override
	public List<String> findAllIds() {
		return this.treinoRepository.findAllJustId();
	}

	@Override
	public void save(Treino treino) {
		treinoRepository.save(treino);
	}

	@Override
	public void update(Treino treino) {
		treinoRepository.save(treino);
	}

	@Override
	public Treino findById(String id) {
		return this.treinoRepository.findById(id).get();
	}

	@Override
	public List<Treino> findAll() {
		return (List<Treino>) this.treinoRepository.findAll();
	}

	@Override
	public void delete(Treino treino) {
		this.treinoRepository.delete(treino);
	}

	@Override
	public List<Treino> findAllWithoutDefault() {
		return this.treinoRepository.findByPadrao(false);
	}
}
