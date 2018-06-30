package br.com.gr.bodyshock.service.impl;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.Sexo;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.CalculoService;


@Service
public class CalculoServiceImpl implements CalculoService {

	private Double calculoDensidadeCorporal(Avaliado avaliado, Avaliacao avaliacao) {
		Double densidadeCorporal = 0.0;
		if (avaliado.getSexo() == Sexo.MASCULINO) {
			densidadeCorporal = (1.10938
					- (0.0008267 * (avaliacao.getdAbdominal() + avaliacao.getdToracica() + avaliacao.getdCoxa()))
					+ (0.0000016
							* Math.pow(avaliacao.getdAbdominal() + avaliacao.getdToracica() + avaliacao.getdCoxa(), 2)
							- (0.0002574 * avaliado.getIdade())));

			avaliado.setDensidadeCorporal(densidadeCorporal);
		} else if (avaliado.getSexo() == Sexo.FEMININO) {
			densidadeCorporal = (1.0994921
					- (0.0009929 * (avaliacao.getdTriciptal() + avaliacao.getdSupraIliaca() + avaliacao.getdCoxa()))
					+ (0.0000023 * Math
							.pow(avaliacao.getdTriciptal() + avaliacao.getdSupraIliaca() + avaliacao.getdCoxa(), 2)
							- (0.0001393 * avaliado.getIdade())));
			avaliado.setDensidadeCorporal(densidadeCorporal);
		}

		return densidadeCorporal;
	}

	private void calculoPorcentagemGordura(Avaliado avaliado, Avaliacao avaliacao) {
		Double valor = ((4.95 / this.calculoDensidadeCorporal(avaliado, avaliacao)) - 4.5) * 100;
		avaliacao.setPorcentagemGordura(formataResultado(valor));
	}

	private Double formataResultado(Double valor) {
		DecimalFormat df = new DecimalFormat("###.##");
		String s = df.format(valor);
		s = s.replaceAll(",", ".");
		return Double.parseDouble(s);
	}

	public void calculaPorcentagemGorduraAdipometro(Avaliado avaliado, Avaliacao avaliacao) {
		calculoDensidadeCorporal(avaliado, avaliacao);
		calculoPorcentagemGordura(avaliado, avaliacao);
	}

	public void calculaPorcentagemGorduraFitaMetrica(Avaliado avaliado, Avaliacao avaliacao) {
		double resultado = 0;
		if (avaliado.getSexo() == Sexo.MASCULINO)
			resultado = 86.010 * Math.log10(avaliacao.getPerimetros().getAbdomen() - avaliacao.getPerimetros().getPescoco()) - 70.041 * Math.log10(avaliacao.getAltura()) + 30.30;
			//resultado = 495 / (1.0324 - 0.19077 * (Math.log(avaliacao.getPerimetros().getCintura() - avaliacao.getPerimetros().getPescoco())) + 0.15456 * (Math.log(avaliacao.getAltura()))) - 450;

		if (avaliado.getSexo() == Sexo.FEMININO)
			resultado = 158.205
					* Math.log10(avaliacao.getPerimetros().getAbdomen() + avaliacao.getPerimetros().getCintura()
							- avaliacao.getPerimetros().getPescoco())
					- 97.684 * Math.log10(avaliacao.getAltura()) - 104.912;

		avaliacao.setPorcentagemGordura(formataResultado(resultado));
	}

}