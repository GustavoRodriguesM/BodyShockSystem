package br.com.gr.bodyshock.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gr.bodyshock.enums.TipoDado;
import br.com.gr.bodyshock.model.DadoGrafico;

public interface DadoGraficoRepository extends CrudRepository<DadoGrafico, Long>{

	List<DadoGrafico> findByTipoDado(TipoDado tipoDado);

}
