package br.com.gr.bodyshock.enums;

public enum TipoAvaliacao {

	FITA_METRICA(1, "Fita métrica"), ADIPOMETRO(2, "Adipômetro");

	private int id;
	private String descricao;

	private TipoAvaliacao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
