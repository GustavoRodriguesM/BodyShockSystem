package br.com.gr.bodyshock.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.Sexo;
import br.com.gr.bodyshock.enums.TipoAvaliacao;
import br.com.gr.bodyshock.exception.ScheduleException;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Dieta;
import br.com.gr.bodyshock.model.Horario;
import br.com.gr.bodyshock.model.Treino;
import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.repository.AvaliadoRepository;
import br.com.gr.bodyshock.repository.DietaRepository;
import br.com.gr.bodyshock.repository.TreinoRepository;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.service.CalculoService;
import br.com.gr.bodyshock.service.DietaService;
import br.com.gr.bodyshock.service.TreinoService;
import br.com.gr.bodyshock.service.UsuarioService;

@Service
public class AvaliadoServiceImpl implements AvaliadoService {

	@Autowired
	private AvaliadoRepository avaliadoRepository;

	@Autowired
	private DietaRepository dietaRepository;

	@Autowired
	private TreinoRepository treinoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DietaService dietaService;

	@Autowired
	private TreinoService treinoService;

	@Autowired
	private CalculoService calculoService;

	@Value("${app.url}")
	private String baseUrl;

	@Override
	public List<Avaliado> buscaSomenteNome() {
		return this.avaliadoRepository.findAllJustName();
	}

	@Override
	public Avaliado findByUser(Usuario usuario) {
		Avaliado avaliado = this.avaliadoRepository.findByUsuario(usuario);
		return avaliado;
	}

	@Override
	public void calculatesFatPercentage(Avaliado avaliado, Avaliacao avaliacao) {
		if (avaliacao.getTipoAvaliacao() == TipoAvaliacao.ADIPOMETRO)
			this.calculoService.calculaPorcentagemGorduraAdipometro(avaliado, avaliacao);
		else if (avaliacao.getTipoAvaliacao() == TipoAvaliacao.FITA_METRICA)
			this.calculoService.calculaPorcentagemGorduraFitaMetrica(avaliado, avaliacao);
	}

	@Override
	public void changeDietAndTraining(Long idAvaliado, String idDieta, String idTreino) {

		Avaliado avaliado = avaliadoRepository.findById(idAvaliado).get();
		Dieta dieta = dietaRepository.findById(idDieta).get();
		Treino treino = treinoRepository.findById(idTreino).get();
		avaliado.setTreino(treino);
		avaliado.setDieta(dieta);
		avaliadoRepository.save(avaliado);

	}

	@Override
	public Avaliado findByEmail(String email) {
		return this.findByUser(usuarioService.findByEmail(email));
	}

	@Override
	public void addDayTraining(Avaliado avaliado) {
		Integer diaTreino = avaliado.getDiaTreino();
		Integer diasTreinados = avaliado.getDiasTreinados();

		if (diaTreino == 9)
			diaTreino = 1;
		else
			diaTreino++;
		diasTreinados++;

		String treinoId = avaliado.getTreino().getId();
		if (treinoId.length() > 0)
			treinoId = treinoId.substring(0, treinoId.length() - 1);

		Treino treino = new Treino();
		treino.setId(treinoId + diaTreino);

		avaliado.setDiasTreinados(diasTreinados);
		avaliado.setDiaTreino(diaTreino);
		avaliado.setTreino(treino);
		avaliadoRepository.save(avaliado);

	}

	@Override
	public void save(Avaliado avaliado) {
		avaliado.setDiasTreinados(1);
		avaliado.setDiaTreino(1);
		avaliadoRepository.save(avaliado);
	}

	@Override
	public void update(Avaliado avaliado) {
		this.avaliadoRepository.save(avaliado);
	}

	@Override
	public Avaliado findById(Long id) {
		Avaliado avaliado = this.avaliadoRepository.findById(id).get();
		return avaliado;
	}

	@Override
	public List<Avaliado> findAll() {
		return (List<Avaliado>) this.avaliadoRepository.findAll();
	}

	@Override
	public void delete(Avaliado avaliado) {
		this.avaliadoRepository.delete(avaliado);
	}

	@Override
	public void calculatesIdealFatPercentage(Avaliado avaliado, Avaliacao avaliacao) {

		if (avaliado.getSexo() == Sexo.MASCULINO) {
			if (avaliado.getIdade() >= 16 && avaliado.getIdade() <= 29)
				avaliacao.setPorcentagemGorduraIdeal(15.0);
			if (avaliado.getIdade() >= 30 && avaliado.getIdade() <= 39)
				avaliacao.setPorcentagemGorduraIdeal(17.0);
			if (avaliado.getIdade() >= 40 && avaliado.getIdade() <= 49)
				avaliacao.setPorcentagemGorduraIdeal(22.0);
			if (avaliado.getIdade() >= 50 && avaliado.getIdade() <= 59)
				avaliacao.setPorcentagemGorduraIdeal(24.0);
			if (avaliado.getIdade() >= 60)
				avaliacao.setPorcentagemGorduraIdeal(24.0);

		} else if (avaliado.getSexo() == Sexo.FEMININO) {
			if (avaliado.getIdade() >= 16 && avaliado.getIdade() <= 29)
				avaliacao.setPorcentagemGorduraIdeal(20.0);
			if (avaliado.getIdade() >= 30 && avaliado.getIdade() <= 39)
				avaliacao.setPorcentagemGorduraIdeal(22.0);
			if (avaliado.getIdade() >= 40 && avaliado.getIdade() <= 49)
				avaliacao.setPorcentagemGorduraIdeal(24.0);
			if (avaliado.getIdade() >= 50 && avaliado.getIdade() <= 59)
				avaliacao.setPorcentagemGorduraIdeal(26.0);
			if (avaliado.getIdade() >= 60)
				avaliacao.setPorcentagemGorduraIdeal(26.0);

		}

	}

	@Override
	public String createCode(Avaliado avaliado, Avaliacao avaliacao) {
		String codigo = null;
		int altura;
		int peso;
		long pesoAvaliado;

		if (avaliado.getSexo() == Sexo.MASCULINO) {
			altura = (int) (Math.floor((avaliacao.getAltura() / 10)) * 10);
			codigo = "M";
			if (altura < 160)
				codigo += "150160";
			else if (altura >= 190) {
				codigo += "190+";
				if (avaliacao.getPeso() > 90)
					return codigo += "/90+";
				else
					return codigo += "/-90";
			} else
				codigo += "" + altura + "" + (altura + 10);

			peso = Integer.parseInt((codigo.split("0")[0] + "0").replace("M", "")) - 100;
			pesoAvaliado = (long) (Math.floor((avaliacao.getPeso() / 10)) * 10);

			if (avaliacao.getPeso() < peso)
				return codigo += "/-" + peso;
			else if (avaliacao.getPeso() > peso + 20)
				return codigo += "/" + (peso + 20) + "+";
			else
				return codigo += "/" + pesoAvaliado + (pesoAvaliado + 10);
		} else {

			altura = (int) ((long) (Math.floor((avaliacao.getAltura() / 10)) * 10) + 5);
			codigo = "F";
			if (altura < 155)
				codigo += "145155";
			else if (altura >= 185) {
				codigo += "185+";
				if (avaliacao.getPeso() > 90)
					return codigo += "/90+";
				else
					return codigo += "/-90";
			} else
				codigo += "" + (altura + 5) + "" + (altura + 15);

			peso = Integer.parseInt((codigo.split("5")[0] + "0").replace("F", "")) - 100;
			pesoAvaliado = (long) (Math.floor((avaliacao.getPeso() / 10)) * 10);

			if (avaliacao.getPeso() < peso)
				return codigo += "/-" + peso;
			else if (avaliacao.getPeso() > peso + 20)
				return codigo += "/" + (peso + 20) + "+";
			else
				return codigo += "/" + pesoAvaliado + (pesoAvaliado + 10);
		}
	}

	@Override
	public void calculatesMeals(Avaliado avaliado) throws ScheduleException {
		List<Horario> horarios = new ArrayList<>();

		if (avaliado.getHoraDorme() == 0)
			avaliado.setHoraDorme(24);
		else if (avaliado.getHoraDorme() == 1)
			avaliado.setHoraDorme(25);
		else if (avaliado.getHoraDorme() == 2)
			avaliado.setHoraDorme(26);
		else if (avaliado.getHoraDorme() == 3)
			avaliado.setHoraDorme(27);

		int protocolo = ((avaliado.getHoraDorme() - avaliado.getHoraAcorda()) / 3) + 1;

		if (protocolo >= 7)
			protocolo = 7;

		avaliado.setProtocolo(protocolo);

		int horario = avaliado.getHoraAcorda() - 3;
		for (int i = 1; i <= protocolo; i++) {
			horario += 3;

			if (horario == avaliado.getHoraDorme())
				horario -= 1;

			horarios.add(new Horario(i, horario));

		}

		if (horarios.isEmpty())
			throw new ScheduleException();

		Collections.reverse(horarios);
		avaliado.setHorarios(horarios);
	}

	@Override
	public void classifyResistenceTest(Avaliado avaliado) {
		Integer abdominais = avaliado.getTesteResistencia().getAbdominais();
		Integer flexoes = avaliado.getTesteResistencia().getFlexao();

		if (abdominais <= 15)
			avaliado.getTesteResistencia().setResultAbdominais("FRACO");
		if (abdominais > 15 && abdominais < 26)
			avaliado.getTesteResistencia().setResultAbdominais("REGULAR");
		if (abdominais >= 26 && abdominais <= 36)
			avaliado.getTesteResistencia().setResultAbdominais("BOM");
		if (abdominais > 37)
			avaliado.getTesteResistencia().setResultAbdominais("EXCELENTE");

		if (flexoes <= 10)
			avaliado.getTesteResistencia().setResultFlexao("FRACO");
		if (flexoes > 10 && flexoes <= 20)
			avaliado.getTesteResistencia().setResultFlexao("REGULAR");
		if (flexoes >= 21 && flexoes <= 30)
			avaliado.getTesteResistencia().setResultFlexao("BOM");
		if (flexoes >= 31)
			avaliado.getTesteResistencia().setResultFlexao("EXCELENTE");

	}

	@Override
	public void directsDietAndTrainig(Avaliado avaliado, Avaliacao avaliacao) {
		String codigo = this.createCode(avaliado, avaliacao);

		try {
			Dieta dieta = dietaService.findById(codigo + "R" + avaliado.getProtocolo());
			Treino treino = treinoService.findById(codigo + "D1");

			avaliado.setDieta(dieta);
			avaliado.setTreino(treino);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getReturnMessage(Avaliado avaliado) {
		if (avaliado.getDiasTreinados() >= 65 && avaliado.getDiasTreinados() < 70)
			return "Você está proximo de completar sua serie!<br>Restam "
					+ (70 - avaliado.getDiasTreinados() + " dias de treino para seu retorno!");
		else if (avaliado.getDiasTreinados() >= 70)
			return "Você terminou sua serie de 10 semanas de treino!<br>"
					+ "<a href='" + baseUrl + "'>Clique aqui</a> para realizar seu retorno gratuitamente!";
		return null;
	}

	@Override
	public List<Avaliado> findByPageRequest(PageRequest pageRequest) {
		return this.avaliadoRepository.findAll(pageRequest).getContent();
	}

	@Override
	public void alterSchedule(Avaliado avaliado, Avaliacao avaliacao, Integer horaAcorda, Integer horaDorme)
			throws ScheduleException {
		avaliado.setHoraAcorda(horaAcorda);
		avaliado.setHoraDorme(horaDorme);

		calculatesMeals(avaliado);

		if (!avaliacao.isCoaching())
			directsDietAndTrainig(avaliado, avaliacao);

		this.update(avaliado);
	}

}
