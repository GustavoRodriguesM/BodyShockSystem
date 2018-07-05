package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Dieta;
import br.com.gr.bodyshock.repository.DietaRepository;
import br.com.gr.bodyshock.service.DietService;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	private DietaRepository dietaRepository;

	@Override
	public void save(Dieta dieta) {
		this.dietaRepository.save(dieta);
	}

	@Override
	public void update(Dieta dieta) {
		this.dietaRepository.save(dieta);
	}

	@Override
	public List<Dieta> findAll() {
		return (List<Dieta>) this.dietaRepository.findAll();
	}

	@Override
	public Dieta findById(String id) {
		return this.dietaRepository.findById(id).get();
	}

	@Override
	public void delete(Dieta dieta) {
		this.dietaRepository.delete(dieta);
	}

	@Override
	public List<Dieta> findAllWithoutDefault() {
		return this.dietaRepository.findByPadrao(false);
	}

	@Override
	public List<String> findAllIds() {
		return this.dietaRepository.findAllJustId();
	}
}
