package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Anamnese;
import br.com.gr.bodyshock.repository.AnamneseRepository;
import br.com.gr.bodyshock.service.AnamnesisService;

@Service
public class AnamnesisServiceImpl implements AnamnesisService {

	@Autowired
	private AnamneseRepository anamneseRepository;

	@Override
	public void save(Anamnese anamnese) {
		this.anamneseRepository.save(anamnese);
	}

	@Override
	public void update(Anamnese anamnese) {
		this.anamneseRepository.save(anamnese);
	}

	@Override
	public Anamnese findById(Long id) {
		return this.anamneseRepository.findById(id).get();
	}

	@Override
	public List<Anamnese> findAll() {
		return (List<Anamnese>) this.anamneseRepository.findAll();
	}

	@Override
	public void delete(Anamnese anamnese) {
		this.anamneseRepository.delete(anamnese);
	}

}
