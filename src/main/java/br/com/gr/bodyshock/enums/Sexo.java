package br.com.gr.bodyshock.enums;

public enum Sexo {

	FEMININO(1, "Feminino"), MASCULINO(2, "Masculino");

	private int id;
	private String descricao;

	private Sexo(int id, String descricao) {
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
