package br.com.gr.bodyshock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.TesteResistencia;
import br.com.gr.bodyshock.repository.TesteResistenciaRepository;
import br.com.gr.bodyshock.service.ResistenceTestService;

@Service
public class ResistenceTestServiceImpl implements ResistenceTestService {

	@Autowired
	private TesteResistenciaRepository testeResistenciaRepository;

	@Override
	public void save(TesteResistencia testeResistencia) {
		this.testeResistenciaRepository.save(testeResistencia);
	}

	@Override
	public void update(TesteResistencia testeResistencia) {
		this.testeResistenciaRepository.save(testeResistencia);
	}

	@Override
	public TesteResistencia findById(Long id) {
		return this.testeResistenciaRepository.findById(id).get();
	}

	@Override
	public List<TesteResistencia> findAll() {
		return (List<TesteResistencia>) this.testeResistenciaRepository.findAll();
	}

	@Override
	public void delete(TesteResistencia testeResistencia) {
		this.testeResistenciaRepository.delete(testeResistencia);
	}

}
