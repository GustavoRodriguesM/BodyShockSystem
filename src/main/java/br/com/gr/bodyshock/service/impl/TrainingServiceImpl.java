package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Treino;
import br.com.gr.bodyshock.repository.TrainingRepository;
import br.com.gr.bodyshock.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public List<String> findAllIds() {
		return this.trainingRepository.findAllJustId();
	}

	@Override
	public void save(Treino treino) {
		trainingRepository.save(treino);
	}

	@Override
	public void update(Treino treino) {
		trainingRepository.save(treino);
	}

	@Override
	public Treino findById(String id) {
		return this.trainingRepository.findById(id).get();
	}

	@Override
	public List<Treino> findAll() {
		return (List<Treino>) this.trainingRepository.findAll();
	}

	@Override
	public void delete(Treino treino) {
		this.trainingRepository.delete(treino);
	}

	@Override
	public List<Treino> findAllWithoutDefault() {
		return this.trainingRepository.findByPadrao(false);
	}
}
