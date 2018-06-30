package br.com.gr.bodyshock.wrapper;

import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;

public class AvaliadoAvaliacaoWrapper {

	private Avaliado avaliado;
	private Avaliacao avaliacao;

	public AvaliadoAvaliacaoWrapper(Avaliado avaliado, Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
		this.avaliado = avaliado;
	}
	
	public AvaliadoAvaliacaoWrapper() {
	}

	public Avaliado getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(Avaliado avaliado) {
		this.avaliado = avaliado;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
