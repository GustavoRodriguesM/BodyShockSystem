package br.com.gr.bodyshock.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.gr.bodyshock.enums.Sexo;

@Entity
public class Avaliado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Usuario usuario;

	@Column(columnDefinition = "int default 1")
	private Integer diaTreino;

	@Column(columnDefinition = "int default 1")
	private Integer diasTreinados;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@OneToMany(mappedBy = "avaliado")
	private List<Avaliacao> avaliacoes;

	@OneToOne
	private TesteResistencia testeResistencia;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;

	@Transient
	private Double densidadeCorporal;

	private Integer horaAcorda;
	private Integer horaDorme;
	private Integer protocolo;

	@ElementCollection
	private List<Horario> horarios;

	@OneToOne
	private Anamnese anamnese;

	@ManyToOne
	private Dieta dieta;

	@ManyToOne
	private Treino treino;

	public Avaliado() {
	}

	public Avaliado(Long id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public List<Avaliacao> getAvaliacoes() {
		Collections.reverse(avaliacoes);
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public Integer getDiasTreinados() {
		return diasTreinados;
	}

	public void setDiasTreinados(Integer diasTreinados) {
		this.diasTreinados = diasTreinados;
	}

	public Integer getProtocolo() {
		return protocolo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setProtocolo(Integer protocolo) {
		this.protocolo = protocolo;
	}

	public List<Horario> getHorarios() {
		Collections.sort(horarios);
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Integer getHoraAcorda() {
		return horaAcorda;
	}

	public Integer getDiaTreino() {
		return diaTreino;
	}

	public void setDiaTreino(Integer diaTreino) {
		this.diaTreino = diaTreino;
	}

	public void setHoraAcorda(Integer horaAcorda) {
		this.horaAcorda = horaAcorda;
	}

	public Integer getHoraDorme() {
		return horaDorme;
	}

	public void setHoraDorme(Integer horaDorme) {
		this.horaDorme = horaDorme;
	}

	public Anamnese getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TesteResistencia getTesteResistencia() {
		return testeResistencia;
	}

	public void setTesteResistencia(TesteResistencia testeResistencia) {
		this.testeResistencia = testeResistencia;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setDensidadeCorporal(Double densidadeCorporal) {
		this.densidadeCorporal = densidadeCorporal;
	}

	public Long getId() {
		return id;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Integer getIdade() {

		Calendar dataNasc = Calendar.getInstance();
		dataNasc.setTime(dataNascimento.getTime());
		Calendar dataAtual = Calendar.getInstance();
		Integer diferencaMes = dataAtual.get(Calendar.MONTH) - dataNasc.get(Calendar.MONTH);
		Integer diferencaDia = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNasc.get(Calendar.DAY_OF_MONTH);
		Integer idade = (dataAtual.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR));
		if (diferencaMes < 0 || (diferencaMes == 0 && diferencaDia < 0)) {
			idade--;
		}
		return idade;
	}

	public Double getDensidadeCorporal() {
		return densidadeCorporal;
	}

}
