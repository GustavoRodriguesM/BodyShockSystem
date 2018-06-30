package br.com.gr.bodyshock.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

	Long countByDataAfterAndStatus(Calendar calendar, Status status);

	Long countByStatus(Status status);

	List<Avaliacao> findAllByStatus(Status status);
	
	Page<Avaliacao> findAllByOrderByDataDesc(Pageable pageable);

	List<Avaliacao> findByAvaliadoOrderByDataAsc(Avaliado avaliado);

	List<Avaliacao> findAllByAvaliado(Avaliado avaliado);
	
	Avaliacao findByAvaliadoAndAtivacao(Avaliado avaliado, Ativacao ativacao);

}
