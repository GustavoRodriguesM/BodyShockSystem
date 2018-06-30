package br.com.gr.bodyshock.enums;

public enum Status {
	PENDENTE(1, "Pendente"), PAGO(2, "Pago"), RETORNO(3, "Retorno");

	private int id;
	private String descricao;

	private Status(int id, String descricao) {
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
