package br.com.gr.bodyshock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TesteResistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer abdominais;
	private String resultAbdominais;
	private Integer flexao;
	private String resultFlexao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResultAbdominais() {
		return resultAbdominais;
	}

	public void setResultAbdominais(String resultAbdominais) {
		this.resultAbdominais = resultAbdominais;
	}

	public String getResultFlexao() {
		return resultFlexao;
	}

	public void setResultFlexao(String resultFlexao) {
		this.resultFlexao = resultFlexao;
	}

	public Integer getAbdominais() {
		return abdominais;
	}

	public void setAbdominais(Integer abdominais) {
		this.abdominais = abdominais;
	}

	public Integer getFlexao() {
		return flexao;
	}

	public void setFlexao(Integer flexao) {
		this.flexao = flexao;
	}

}
