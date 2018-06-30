package br.com.gr.bodyshock.enums;

public enum Ativacao {

	ATIVA(1, "Ativa"), DESATIVA(2, "Desativa");

	private long id;
	private String descricao;

	private Ativacao(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
