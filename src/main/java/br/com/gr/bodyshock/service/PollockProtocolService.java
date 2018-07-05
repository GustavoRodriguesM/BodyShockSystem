package br.com.gr.bodyshock.service;

import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;

public interface PollockProtocolService {

	void calculaPorcentagemGorduraAdipometro(Avaliado avaliado, Avaliacao avaliacao);

	void calculaPorcentagemGorduraFitaMetrica(Avaliado avaliado, Avaliacao avaliacao);

}
