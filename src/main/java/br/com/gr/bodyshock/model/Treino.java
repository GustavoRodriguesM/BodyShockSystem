package br.com.gr.bodyshock.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Treino {

	@Id
	private String id;

	private String titulo;

	private String cardio;
	private String exer1;
	private String exer1GIF;
	private String exer2;
	private String exer2GIF;
	private String exer3;
	private String exer3GIF;
	private String exer4;
	private String exer4GIF;
	private String exer5;
	private String exer5GIF;
	private String exer6;
	private String exer6GIF;
	private String exer7;
	private String exer7GIF;
	private String exer8;
	private String exer8GIF;
	private String exer9;
	private String exer9GIF;
	private String exer10;
	private String exer10GIF;
	private String exer11;
	private String exer11GIF;
	private String exer12;
	private String exer12GIF;
	private String exer13;
	private String exer13GIF;

	private boolean padrao;

	public Treino() {
	}

	public Treino(String id) {
		this.id = id;
	}

	public boolean isPadrao() {
		return padrao;
	}

	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCardio() {
		return cardio;
	}

	public void setCardio(String cardio) {
		this.cardio = cardio;
	}

	public String getExer1() {
		return exer1;
	}

	public void setExer1(String exer1) {
		this.exer1 = exer1;
	}

	public String getExer1GIF() {
		return exer1GIF;
	}

	public void setExer1GIF(String exer1gif) {
		this.exer1GIF = exer1gif;
	}

	public String getExer2() {
		return exer2;
	}

	public void setExer2(String exer2) {
		this.exer2 = exer2;
	}

	public String getExer2GIF() {
		return exer2GIF;
	}

	public void setExer2GIF(String exer2gif) {
		exer2GIF = exer2gif;
	}

	public String getExer3() {
		return exer3;
	}

	public void setExer3(String exer3) {
		this.exer3 = exer3;
	}

	public String getExer3GIF() {
		return exer3GIF;
	}

	public void setExer3GIF(String exer3gif) {
		exer3GIF = exer3gif;
	}

	public String getExer4() {
		return exer4;
	}

	public void setExer4(String exer4) {
		this.exer4 = exer4;
	}

	public String getExer4GIF() {
		return exer4GIF;
	}

	public void setExer4GIF(String exer4gif) {
		this.exer4GIF = exer4gif;
	}

	public String getExer5() {
		return exer5;
	}

	public void setExer5(String exer5) {
		this.exer5 = exer5;
	}

	public String getExer5GIF() {
		return exer5GIF;
	}

	public void setExer5GIF(String exer5gif) {
		exer5GIF = exer5gif;
	}

	public String getExer6() {
		return exer6;
	}

	public void setExer6(String exer6) {
		this.exer6 = exer6;
	}

	public String getExer6GIF() {
		return exer6GIF;
	}

	public void setExer6GIF(String exer6gif) {
		exer6GIF = exer6gif;
	}

	public String getExer7() {
		return exer7;
	}

	public void setExer7(String exer7) {
		this.exer7 = exer7;
	}

	public String getExer7GIF() {
		return exer7GIF;
	}

	public void setExer7GIF(String exer7gif) {
		exer7GIF = exer7gif;
	}

	public String getExer8() {
		return exer8;
	}

	public void setExer8(String exer8) {
		this.exer8 = exer8;
	}

	public String getExer8GIF() {
		return exer8GIF;
	}

	public void setExer8GIF(String exer8gif) {
		exer8GIF = exer8gif;
	}

	public String getExer9() {
		return exer9;
	}

	public void setExer9(String exer9) {
		this.exer9 = exer9;
	}

	public String getExer9GIF() {
		return exer9GIF;
	}

	public void setExer9GIF(String exer9gif) {
		exer9GIF = exer9gif;
	}

	public String getExer10() {
		return exer10;
	}

	public void setExer10(String exer10) {
		this.exer10 = exer10;
	}

	public String getExer10GIF() {
		return exer10GIF;
	}

	public void setExer10GIF(String exer10gif) {
		exer10GIF = exer10gif;
	}

	public String getExer11() {
		return exer11;
	}

	public void setExer11(String exer11) {
		this.exer11 = exer11;
	}

	public String getExer11GIF() {
		return exer11GIF;
	}

	public void setExer11GIF(String exer11gif) {
		exer11GIF = exer11gif;
	}

	public String getExer12() {
		return exer12;
	}

	public void setExer12(String exer12) {
		this.exer12 = exer12;
	}

	public String getExer12GIF() {
		return exer12GIF;
	}

	public void setExer12GIF(String exer12gif) {
		exer12GIF = exer12gif;
	}

	public String getExer13() {
		return exer13;
	}

	public void setExer13(String exer13) {
		this.exer13 = exer13;
	}

	public String getExer13GIF() {
		return exer13GIF;
	}

	public void setExer13GIF(String exer13gif) {
		exer13GIF = exer13gif;
	}

	public List<Exercicio> getExercicios() {
		List<Exercicio> exercicios = new ArrayList<>();
		if (!this.getExer1().equals("")) {

			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer1().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer1GIF());
			exercicios.add(exercicio);
		}
		if (!this.getExer2().equals("")) {

			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer2().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer2GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer3().equals("")) {

			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer3().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer3GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer4().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer4().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer4GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer5().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer5().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer5GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer6().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer6().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer6GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer7().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer7().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer7GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer8().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer8().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer8GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer9().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer9().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer9GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer10().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer10().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer10GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer11().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer11().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer11GIF());
			exercicios.add(exercicio);
		}

		if (!this.getExer12().equals("")) {
			Exercicio exercicio = new Exercicio();
			exercicio.setDescricao(
					this.getExer12().replace("ou qualquer outra disponivel", " ").replace(" com ", " "));
			exercicio.setGif(this.getExer12GIF());
			exercicios.add(exercicio);
		}

		return exercicios;
	}

}
