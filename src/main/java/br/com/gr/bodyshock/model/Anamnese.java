package br.com.gr.bodyshock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anamnese {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String praticouMusculacao;
	private String doencaHereditaria;
	private String doencaPessoal;
	private String restricaoPraticaAtivFisica;
	private String cirurgiaRecente;
	private String alergias;
	private String fuma;
	@Column(length = 3000)
	private String complemento;


	public Anamnese() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPraticouMusculacao() {
		return praticouMusculacao;
	}

	public void setPraticouMusculacao(String praticouMusculacao) {
		this.praticouMusculacao = praticouMusculacao;
	}

	public String getDoencaHereditaria() {
		return doencaHereditaria;
	}

	public void setDoencaHereditaria(String doencaHereditaria) {
		this.doencaHereditaria = doencaHereditaria;
	}

	public String getDoencaPessoal() {
		return doencaPessoal;
	}

	public void setDoencaPessoal(String doencaPessoal) {
		this.doencaPessoal = doencaPessoal;
	}

	public String getRestricaoPraticaAtivFisica() {
		return restricaoPraticaAtivFisica;
	}

	public void setRestricaoPraticaAtivFisica(String restricaoPraticaAtivFisica) {
		this.restricaoPraticaAtivFisica = restricaoPraticaAtivFisica;
	}

	public String getCirurgiaRecente() {
		return cirurgiaRecente;
	}

	public void setCirurgiaRecente(String cirurgiaRecente) {
		this.cirurgiaRecente = cirurgiaRecente;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getFuma() {
		return fuma;
	}

	public void setFuma(String fuma) {
		this.fuma = fuma;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
