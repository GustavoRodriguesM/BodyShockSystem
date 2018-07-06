package br.com.gr.bodyshock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.gr.bodyshock.model.Dieta;


public interface DietRepository extends CrudRepository<Dieta, String>{

	@Query("select new br.com.gr.bodyshock.model.Dieta(d.id) from Dieta d")
	List<String> findAllJustId();

	List<Dieta> findByPadrao(boolean b);

}
