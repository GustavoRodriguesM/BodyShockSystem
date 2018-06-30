package br.com.gr.bodyshock.model;

import javax.persistence.Embeddable;

@Embeddable
public class Horario implements Comparable<Horario>{

	private Integer posicao;
	private Integer horario;

	public Horario(Integer posicao, Integer horario) {
		this.posicao = posicao;
		this.horario = horario;
	}

	public Horario() {
	} // JPA

	public Integer getHorario() {
		return horario;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	@Override
	public int compareTo(Horario outroHorario) {
		if (this.posicao < outroHorario.getPosicao())
			return -1;

		if (this.posicao > outroHorario.getPosicao())
			return 1;

		return 0;
	}
}
