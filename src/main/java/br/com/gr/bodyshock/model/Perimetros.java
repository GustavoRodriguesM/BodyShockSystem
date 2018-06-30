package br.com.gr.bodyshock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perimetros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double torax;
	private Double cintura;
	private Double abdomen;
	private Double quadril;
	private Double anteBracoD;
	private Double anteBracoE;
	private Double bicepsD;
	private Double bicepsE;
	private Double coxaD;
	private Double coxaE;
	private Double panturrilhaD;
	private Double panturrilhaE;
	private Double pescoco;

	public Double getPescoco() {
		return pescoco;
	}

	public void setPescoco(Double pescoco) {
		this.pescoco = pescoco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTorax() {
		return torax;
	}

	public void setTorax(Double torax) {
		this.torax = torax;
	}

	public Double getCintura() {
		return cintura;
	}

	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	public Double getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Double abdomen) {
		this.abdomen = abdomen;
	}

	public Double getQuadril() {
		return quadril;
	}

	public void setQuadril(Double quadril) {
		this.quadril = quadril;
	}

	public Double getAnteBracoD() {
		return anteBracoD;
	}

	public void setAnteBracoD(Double anteBracoD) {
		this.anteBracoD = anteBracoD;
	}

	public Double getAnteBracoE() {
		return anteBracoE;
	}

	public void setAnteBracoE(Double anteBracoE) {
		this.anteBracoE = anteBracoE;
	}

	public Double getBicepsD() {
		return bicepsD;
	}

	public void setBicepsD(Double bicepsD) {
		this.bicepsD = bicepsD;
	}

	public Double getBicepsE() {
		return bicepsE;
	}

	public void setBicepsE(Double bicepsE) {
		this.bicepsE = bicepsE;
	}

	public Double getCoxaD() {
		return coxaD;
	}

	public void setCoxaD(Double coxaD) {
		this.coxaD = coxaD;
	}

	public Double getCoxaE() {
		return coxaE;
	}

	public void setCoxaE(Double coxaE) {
		this.coxaE = coxaE;
	}

	public Double getPanturrilhaD() {
		return panturrilhaD;
	}

	public void setPanturrilhaD(Double panturrilhaD) {
		this.panturrilhaD = panturrilhaD;
	}

	public Double getPanturrilhaE() {
		return panturrilhaE;
	}

	public void setPanturrilhaE(Double panturrilhaE) {
		this.panturrilhaE = panturrilhaE;
	}

}
