package br.com.gr.bodyshock.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Relatorio;
import br.com.gr.bodyshock.repository.RelatorioRepository;
import br.com.gr.bodyshock.service.RelatorioService;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private RelatorioRepository relatorioRepository;

	@Override
	public List<Relatorio> findLastFive() {
		return (List<Relatorio>) this.relatorioRepository.findByLimit(5);
	}

	@Override
	public void makeRegistrationReport(Avaliacao avaliacao) {
		String tipo;
		if (!avaliacao.isCoaching())
			tipo = "COMUM";
		else
			tipo = "COACHING ONLINE";

		String descricao = "AVALIACAO " + avaliacao.getId() + " - " + tipo + " - CADASTRADA POR "
				+ avaliacao.getAvaliado().getUsuario().getNome().toUpperCase();

		Relatorio relatorio = new Relatorio(descricao, Calendar.getInstance());

		relatorioRepository.save(relatorio);
	}

	@Override
	public void makePhysicalTestValidationReport(Avaliacao avaliacao) {
		String descricao = null;

		if (avaliacao.getStatus() == Status.PAGO)
			descricao = "AVALIACAO " + avaliacao.getId() + " VALIDADA";
		else
			descricao = "AVALIACAO " + avaliacao.getId() + " INVALIDADA";

		Relatorio relatorio = new Relatorio(descricao, Calendar.getInstance());

		relatorioRepository.save(relatorio);
	}

	@Override
	public void save(Relatorio relatorio) {
		this.relatorioRepository.save(relatorio);
	}

	@Override
	public void update(Relatorio relatorio) {
		this.relatorioRepository.save(relatorio);
	}

	@Override
	public Relatorio findById(Long id) {
		return this.relatorioRepository.findById(id).get();
	}

	@Override
	public List<Relatorio> findAll() {
		return (List<Relatorio>) this.relatorioRepository.findAll();
	}

	@Override
	public void delete(Relatorio relatorio) {
		this.relatorioRepository.delete(relatorio);
	}

}
