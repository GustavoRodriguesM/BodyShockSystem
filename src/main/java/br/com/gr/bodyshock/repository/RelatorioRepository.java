package br.com.gr.bodyshock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.gr.bodyshock.model.Relatorio;

public interface RelatorioRepository extends CrudRepository<Relatorio, Long>{
	
	@Query(value="select r.* from relatorio r order by r.id desc limit ?1 ", nativeQuery=true)
	List<Relatorio> findByLimit(int notifications);

}
