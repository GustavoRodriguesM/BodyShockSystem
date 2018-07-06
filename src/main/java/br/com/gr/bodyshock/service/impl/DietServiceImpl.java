package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Dieta;
import br.com.gr.bodyshock.repository.DietRepository;
import br.com.gr.bodyshock.service.DietService;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	private DietRepository dietRepository;

	@Override
	public void save(Dieta dieta) {
		this.dietRepository.save(dieta);
	}

	@Override
	public void update(Dieta dieta) {
		this.dietRepository.save(dieta);
	}

	@Override
	public List<Dieta> findAll() {
		return (List<Dieta>) this.dietRepository.findAll();
	}

	@Override
	public Dieta findById(String id) {
		return this.dietRepository.findById(id).get();
	}

	@Override
	public void delete(Dieta dieta) {
		this.dietRepository.delete(dieta);
	}

	@Override
	public List<Dieta> findAllWithoutDefault() {
		return this.dietRepository.findByPadrao(false);
	}

	@Override
	public List<String> findAllIds() {
		return this.dietRepository.findAllJustId();
	}
}
