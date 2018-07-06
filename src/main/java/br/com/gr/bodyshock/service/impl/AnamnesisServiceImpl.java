package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Anamnese;
import br.com.gr.bodyshock.repository.AnamnesisRepository;
import br.com.gr.bodyshock.service.AnamnesisService;

@Service
public class AnamnesisServiceImpl implements AnamnesisService {

	@Autowired
	private AnamnesisRepository anamnesisRepository;

	@Override
	public void save(Anamnese anamnese) {
		this.anamnesisRepository.save(anamnese);
	}

	@Override
	public void update(Anamnese anamnese) {
		this.anamnesisRepository.save(anamnese);
	}

	@Override
	public Anamnese findById(Long id) {
		return this.anamnesisRepository.findById(id).get();
	}

	@Override
	public List<Anamnese> findAll() {
		return (List<Anamnese>) this.anamnesisRepository.findAll();
	}

	@Override
	public void delete(Anamnese anamnese) {
		this.anamnesisRepository.delete(anamnese);
	}

}
