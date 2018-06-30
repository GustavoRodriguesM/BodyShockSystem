package br.com.gr.bodyshock.service;

import java.util.List;

import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Relatorio;

public interface RelatorioService extends AbstractService<Relatorio, Long> {

	void makePhysicalTestValidationReport(Avaliacao avaliacao);

	void makeRegistrationReport(Avaliacao avaliacao);

	List<Relatorio> findLastFive();

}
