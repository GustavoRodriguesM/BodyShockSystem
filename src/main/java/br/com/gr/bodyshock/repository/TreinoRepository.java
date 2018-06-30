package br.com.gr.bodyshock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.gr.bodyshock.model.Treino;

public interface TreinoRepository extends CrudRepository<Treino, String> {
	@Query("select new br.com.gr.bodyshock.model.Treino(t.id) from Treino t")
	List<String> findAllJustId();

	List<Treino> findByPadrao(boolean b);

}
