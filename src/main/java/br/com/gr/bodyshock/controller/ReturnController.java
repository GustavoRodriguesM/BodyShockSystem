package br.com.gr.bodyshock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Sexo;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.AvaliacaoService;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.service.PerimetrosService;

@Controller
public class ReturnController extends AbstractController {

	private static final String FORM_PAGE = "avaliacao/retornoForm";
	private static final String PHYSICAL_ASSESSMENT_RETURN_PAGE = "avaliacao/retorno";

	@Autowired
	private AvaliadoService avaliadoService;

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private PerimetrosService perimetrosService;

	@GetMapping(MAPPING_AVALIADO + "retorno")
	public ModelAndView retornoForm() {
		Avaliado avaliado = this.avaliadoService.findByUser(getUser());
		List<Avaliacao> avaliacoes = this.avaliacaoService.findByClient(avaliado);
		ModelAndView view = this.modelAndView(FORM_PAGE);

		if (avaliado.getDiasTreinados() >= 70 && avaliacoes.size() == 1) {
			view.addObject("avaliacao", avaliacoes.get(0));
			view.addObject("sexos", Sexo.values());
		} else if (avaliacoes.size() >= 2) {
			view = this.modelAndView(PHYSICAL_ASSESSMENT_RETURN_PAGE);
			avaliacoes = this.avaliacaoService.findByClient(avaliado);
		}

		view.addObject("avaliado", avaliado);
		view.addObject("avaliacoes", avaliacoes);
		return view;
	}

	@PostMapping(MAPPING_AVALIADO + "retorno")
	public ModelAndView retorno(Avaliacao avaliacao, RedirectAttributes attributes) {
		Avaliado avaliado = this.avaliadoService.findByUser(getUser());
		Avaliacao avaliacaoVelha = this.avaliacaoService.findByClientAndActivation(avaliado, Ativacao.ATIVA);

		String mensagem = null;

		try {
			this.avaliadoService.calculatesFatPercentage(avaliado, avaliacao);
			this.avaliadoService.calculatesMeals(avaliado);

			if (!avaliacao.isCoaching())
				this.avaliadoService.directsDietAndTrainig(avaliado, avaliacao);

			this.perimetrosService.save(avaliacao.getPerimetros());
			this.avaliadoService.save(avaliado);
			this.avaliacaoService.disable(avaliacaoVelha);
			this.avaliacaoService.save(avaliacao, avaliado, Status.RETORNO);
			mensagem = this.successMessage("Avaliação de retorno cadastrada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}

		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);
		return this.redirect("/avaliado/dashboard");
	}

}
