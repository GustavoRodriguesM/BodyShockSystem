package br.com.gr.bodyshock.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import br.com.gr.bodyshock.exception.ScheduleException;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Usuario;

public interface ClientService extends AbstractService<Avaliado, Long> {

	Avaliado findByUser(Usuario usuario);
	
	Avaliado findByEmail(String email);

	List<Avaliado> buscaSomenteNome();

	void changeDietAndTraining(Long idAvaliado, String idDieta, String idTreino);

	void addDayTraining(Avaliado avaliado);

	void calculatesFatPercentage(Avaliado avaliado, Avaliacao avaliacao);
	
	void calculatesIdealFatPercentage(Avaliado avaliado, Avaliacao avaliacao);
	
	void directsDietAndTrainig(Avaliado avaliado, Avaliacao avaliacao);
	
	void calculatesMeals(Avaliado aluno) throws ScheduleException;
	
	void classifyResistenceTest(Avaliado aluno);
	
	String createCode(Avaliado avaliado, Avaliacao avaliacao);

	String getReturnMessage(Avaliado avaliado);

	List<Avaliado> findByPageRequest(PageRequest pageRequest);

	void alterSchedule(Avaliado avaliado, Avaliacao avaliacao, Integer horaAcorda, Integer horaDorme) throws ScheduleException;
}
