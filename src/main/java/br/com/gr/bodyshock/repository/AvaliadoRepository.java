package br.com.gr.bodyshock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Usuario;

public interface AvaliadoRepository extends PagingAndSortingRepository<Avaliado, Long>{
	
	@Query("select new br.com.gr.bodyshock.model.Avaliado(a.id, a.usuario) from Avaliado a")
	List<Avaliado> findAllJustName();
	
	Avaliado findByUsuario(Usuario usuario);

}
