package br.com.gr.bodyshock.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.enums.TipoAvaliacao;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double altura;
	private Double peso;
	private Double dToracica;
	private Double dAbdominal;
	private Double dTriciptal;
	private Double dSupraIliaca;
	private Double dCoxa;
	private Double porcentagemGordura;
	private Double porcentagemGorduraIdeal;
	private boolean coaching;

	@Enumerated(EnumType.STRING)
	private TipoAvaliacao tipoAvaliacao;

	@DateTimeFormat
	private Calendar data;

	@DateTimeFormat
	private Calendar dataPagamento;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Ativacao ativacao;

	@OneToOne
	private Perimetros perimetros;

	@ManyToOne
	private Avaliado avaliado;

	public Avaliacao() {
	}

	public Avaliado getAvaliado() {
		return avaliado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAvaliado(Avaliado avaliado) {
		this.avaliado = avaliado;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Perimetros getPerimetros() {
		return perimetros;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public void setPerimetros(Perimetros perimetros) {
		this.perimetros = perimetros;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getPorcentagemGorduraIdeal() {
		return porcentagemGorduraIdeal;
	}

	public void setPorcentagemGorduraIdeal(Double porcentagemGorduraIdeal) {
		this.porcentagemGorduraIdeal = porcentagemGorduraIdeal;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getdToracica() {
		return dToracica;
	}

	public void setdToracica(Double dToracica) {
		this.dToracica = dToracica;
	}

	public Double getdAbdominal() {
		return dAbdominal;
	}

	public void setdAbdominal(Double dAbdominal) {
		this.dAbdominal = dAbdominal;
	}

	public Double getdTriciptal() {
		return dTriciptal;
	}

	public void setdTriciptal(Double dTriciptal) {
		this.dTriciptal = dTriciptal;
	}

	public Double getdSupraIliaca() {
		return dSupraIliaca;
	}

	public void setdSupraIliaca(Double dSupraIliaca) {
		this.dSupraIliaca = dSupraIliaca;
	}

	public Double getdCoxa() {
		return dCoxa;
	}

	public void setdCoxa(Double dCoxa) {
		this.dCoxa = dCoxa;
	}

	public Double getPorcentagemGordura() {
		return porcentagemGordura;
	}

	public void setPorcentagemGordura(Double porcentagemGordura) {
		this.porcentagemGordura = porcentagemGordura;
	}

	public boolean isCoaching() {
		return coaching;
	}

	public void setCoaching(boolean coaching) {
		this.coaching = coaching;
	}

	public Ativacao getAtivacao() {
		return ativacao;
	}

	public void setAtivacao(Ativacao ativacao) {
		this.ativacao = ativacao;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + "\nPeso: " + this.peso + "\nAltura: " + this.altura + "\nAtivação: " + this.ativacao;
	}

	@Override
	public boolean equals(Object obj) {
		Avaliacao outraAvaliacao = (Avaliacao) obj;
		return this.id == outraAvaliacao.getId();
	}
}
