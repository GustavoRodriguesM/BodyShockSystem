package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Perimetros;
import br.com.gr.bodyshock.repository.PerimetrosRepository;
import br.com.gr.bodyshock.service.PerimetersService;

@Service
public class PerimetersServiceImpl implements PerimetersService {

	@Autowired
	private PerimetrosRepository perimetrosRepository;

	@Override
	public void save(Perimetros perimetros) {
		this.perimetrosRepository.save(perimetros);
	}

	@Override
	public void update(Perimetros perimetros) {
		this.perimetrosRepository.save(perimetros);
	}

	@Override
	public Perimetros findById(Long id) {
		return this.perimetrosRepository.findById(id).get();
	}

	@Override
	public List<Perimetros> findAll() {
		return (List<Perimetros>) this.perimetrosRepository.findAll();
	}

	@Override
	public void delete(Perimetros perimetros) {
		this.perimetrosRepository.delete(perimetros);
	}

}
