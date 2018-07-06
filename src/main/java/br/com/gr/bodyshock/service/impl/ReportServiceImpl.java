package br.com.gr.bodyshock.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Relatorio;
import br.com.gr.bodyshock.repository.ReportRepository;
import br.com.gr.bodyshock.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public List<Relatorio> findLastFive() {
		return this.reportRepository.findByLimit(5);
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

		reportRepository.save(relatorio);
	}

	@Override
	public void makePhysicalTestValidationReport(Avaliacao avaliacao) {
		String descricao = null;

		if (avaliacao.getStatus() == Status.PAGO)
			descricao = "AVALIACAO " + avaliacao.getId() + " VALIDADA";
		else
			descricao = "AVALIACAO " + avaliacao.getId() + " INVALIDADA";

		Relatorio relatorio = new Relatorio(descricao, Calendar.getInstance());

		reportRepository.save(relatorio);
	}

	@Override
	public void save(Relatorio relatorio) {
		this.reportRepository.save(relatorio);
	}

	@Override
	public void update(Relatorio relatorio) {
		this.reportRepository.save(relatorio);
	}

	@Override
	public Relatorio findById(Long id) {
		return this.reportRepository.findById(id).get();
	}

	@Override
	public List<Relatorio> findAll() {
		return (List<Relatorio>) this.reportRepository.findAll();
	}

	@Override
	public void delete(Relatorio relatorio) {
		this.reportRepository.delete(relatorio);
	}

}
