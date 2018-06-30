package br.com.gr.bodyshock.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.AvaliacaoService;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.service.impl.DadoGraficoService;

@Controller
public class DashboardController extends AbstractController {

	private static final String ADMIN_DASHBOARD_PAGE = "dashboard/admin";
	private static final String CLIENT_DASHBOARD_PAGE = "dashboard/avaliado";
	private static final String CLIENT_TRIAL_PAGE = "dashboard/degustacao";

	@Autowired
	private DadoGraficoService dadoGraficoService;

	@Autowired
	private AvaliadoService avaliadoService;

	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView view = null;

		if (this.hasRole("ROLE_ADMINISTRADOR"))
			view = administrador();
		else if (this.hasRole("ROLE_AVALIADO"))
			view = avaliado();

		return view;
	}

	private ModelAndView administrador() {
		ModelAndView modelAndView = this.modelAndView(ADMIN_DASHBOARD_PAGE);
		long numeroAvalaicoes = this.avaliacaoService.getSumPhysicalTests();
		Long numeroAvaliacoesMes = this.avaliacaoService.getSumPhysicalTests(Calendar.getInstance(), Status.PAGO);
		Double monetarioPendente = this.avaliacaoService.getPaymentsValue(Status.PENDENTE);
		List<Integer> dados = this.dadoGraficoService.getData();

		modelAndView.addObject("dados", dados);
		modelAndView.addObject("numeroAvaliacoes", numeroAvalaicoes);
		modelAndView.addObject("numeroAvaliacoesMes", numeroAvaliacoesMes);
		modelAndView.addObject("monetarioPendente", monetarioPendente);

		return modelAndView;
	}

	public ModelAndView avaliado() {

		Avaliado avaliado = avaliadoService.findByUser(getUser());
		Avaliacao avaliacao = avaliacaoService.findByClientAndActivation(avaliado, Ativacao.ATIVA);

		if (avaliacao.getStatus() == Status.PENDENTE) {
			ModelAndView view = this.modelAndView(CLIENT_TRIAL_PAGE);

			Double mediaGordura = (double) Math
					.round(avaliacao.getPorcentagemGordura() - avaliacao.getPorcentagemGorduraIdeal());

			view.addObject("avaliado", avaliado);
			view.addObject("avaliacao", avaliacao);
			view.addObject("mediaGordura", mediaGordura);

			return view;
		} else {
			ModelAndView view = this.modelAndView(CLIENT_DASHBOARD_PAGE);
			String msgRetorno = this.avaliadoService.getReturnMessage(avaliado);

			view.addObject("msgRetorno", msgRetorno);
			view.addObject("avaliado", avaliado);
			view.addObject("avaliacao", avaliacao);
			return view;
		}
	}

}
