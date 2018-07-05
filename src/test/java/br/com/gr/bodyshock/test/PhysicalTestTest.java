package br.com.gr.bodyshock.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gr.bodyshock.enums.Sexo;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Perimetros;
import br.com.gr.bodyshock.service.PollockProtocolService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhysicalTestTest {
	
	@Autowired
	private PollockProtocolService calculoService;
	
	@Test
	public void fatPorcentageComparator() {
		Avaliado avaliado = new Avaliado();
		avaliado.setDataNascimento(new GregorianCalendar(1999, 10, 11));
		avaliado.setHoraAcorda(7);
		avaliado.setHoraDorme(23);
		avaliado.setSexo(Sexo.MASCULINO);
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setAltura(172.0);
		avaliacao.setData(Calendar.getInstance());
		
		Perimetros perimetros = new Perimetros();
		perimetros.setAbdomen(85.0);
		perimetros.setAnteBracoD(26.0);
		perimetros.setAnteBracoE(26.0);
		perimetros.setBicepsD(34.0);
		perimetros.setBicepsE(34.0);
		perimetros.setCintura(76.0);
		perimetros.setCoxaD(54.0);
		perimetros.setCoxaE(54.0);
		perimetros.setPanturrilhaD(36.0);
		perimetros.setPanturrilhaE(36.0);
		perimetros.setPescoco(40.0);
		perimetros.setQuadril(93.0);
		perimetros.setTorax(87.0);
		
		avaliacao.setPerimetros(perimetros);
		avaliacao.setdCoxa(22.0);
		avaliacao.setdAbdominal(26.0);
		avaliacao.setdToracica(16.0);
		
		
		calculoService.calculaPorcentagemGorduraAdipometro(avaliado, avaliacao);
		
		System.out.println("Porcentagem de gordura atual com adipometro: " + avaliacao.getPorcentagemGordura());
		
		calculoService.calculaPorcentagemGorduraFitaMetrica(avaliado, avaliacao);
		
		System.out.println("Porcentagem de gordura atual com fita metrica: " + avaliacao.getPorcentagemGordura());
	}

}
