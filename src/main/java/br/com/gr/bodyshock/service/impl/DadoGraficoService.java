package br.com.gr.bodyshock.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.TipoDado;
import br.com.gr.bodyshock.model.DadoGrafico;
import br.com.gr.bodyshock.repository.DadoGraficoRepository;

@Service
public class DadoGraficoService {

	@Autowired
	private DadoGraficoRepository repository;
	
	public void save(TipoDado tipoDado) {
		DadoGrafico dadoGrafico = new DadoGrafico();
		dadoGrafico.setData(Calendar.getInstance());
		dadoGrafico.setValor(1l);
		dadoGrafico.setTipoDado(tipoDado);
		
		repository.save(dadoGrafico);
	}
	
	public List<DadoGrafico> findByTipoDadoOnMonth(TipoDado tipoDado){
		return this.repository.findByTipoDado(tipoDado);
	}
	
	
	public List<Integer> getData(){
		List<Integer> dados = new ArrayList<>();
		dados.add(findByTipoDadoOnMonth(TipoDado.PAGINA_HOME).size());
		dados.add(findByTipoDadoOnMonth(TipoDado.PAGINA_AVALIACAO_COMUM).size());
		dados.add(findByTipoDadoOnMonth(TipoDado.PAGINA_TREINO).size());
		dados.add(findByTipoDadoOnMonth(TipoDado.PAGINA_DIETA).size());
		
		return dados;
	}
}
