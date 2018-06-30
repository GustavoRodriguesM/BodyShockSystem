package br.com.gr.bodyshock.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.PageRequest;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.exception.DietaTreinoException;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;

public interface AvaliacaoService extends AbstractService<Avaliacao, Long> {

	void save(Avaliacao avaliacao, Avaliado avaliado, Status status);
	
	List<Avaliacao> findByClient(Avaliado avaliado);
	
	Long getSumPhysicalTests();
	
	Long getSumPhysicalTests(Calendar calendar, Status status);
	
	Long getSumPhysicalTests(Status status);
	
	Double getPaymentsValue(Status status);
	
	List<Avaliacao> findByStatus(Status status);
	
	void validate(Avaliacao avaliacao) throws DietaTreinoException;

	List<Avaliacao> findByPageRequest(PageRequest pageRequest);

	Avaliacao findByClientAndActivation(Avaliado avaliado, Ativacao ativa);

	void disable(Avaliacao avaliacao);
}
