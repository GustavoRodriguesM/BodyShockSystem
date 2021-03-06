package br.com.gr.bodyshock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.enums.TipoDado;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Treino;
import br.com.gr.bodyshock.service.ClientService;
import br.com.gr.bodyshock.service.TrainingService;
import br.com.gr.bodyshock.service.impl.GraphicalDataService;
import br.com.gr.bodyshock.validator.TreinoValidator;

@Controller
public class TrainingController extends AbstractController {

	private static final String TRAINING_TIPS_PAGE = "training/client/training-tips";

	private static final String INDEX_PAGE = "training/index";
	private static final String NEW_PAGE = "training/new";

	@Autowired
	private TrainingService trainingService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private GraphicalDataService graphicalDataService;

	/*
	 * 
	 * ADMINISTRADOR
	 * 
	 */

	@InitBinder(value = { "treino" })
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new TreinoValidator());
	}

	@GetMapping(MAPPING_ADMIN + "treino/form")
	public ModelAndView form(Treino treino) {
		return this.modelAndView(NEW_PAGE);
	}

	@GetMapping(MAPPING_ADMIN + "treino/form/{id}")
	public ModelAndView formAlteracao(@PathVariable String id) {
		Treino treino = this.trainingService.findById(id);
		return this.modelAndView(NEW_PAGE).addObject("treino", treino);
	}

	@GetMapping(MAPPING_ADMIN + "treino")
	public ModelAndView index() {
		return this.modelAndView(INDEX_PAGE).addObject("treinos", this.trainingService.findAllWithoutDefault());
	}

	@PostMapping(MAPPING_ADMIN + "treino")
	public ModelAndView save(@Valid Treino treino, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors())
			return form(treino);

		try {
			trainingService.save(treino);
			attributes.addFlashAttribute(SWEETMESSAGE_TAG, this.successMessage());
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute(SWEETMESSAGE_TAG, this.errorMessage());
		}

		return this.redirect("/admin/treino");
	}

	@GetMapping(MAPPING_ADMIN + "treino/remove/{id}")
	public ModelAndView remove(@PathVariable String id, RedirectAttributes attributes) {
		String mensagem = null;
		try {
			Treino treino = this.trainingService.findById(id);
			this.trainingService.delete(treino);
			mensagem = this.successMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}
		attributes.addFlashAttribute(SWEETMESSAGE_TAG, mensagem);

		return this.redirect("/admin/treino");
	}

	/*
	 * AVALIADO
	 */
	@GetMapping(MAPPING_AVALIADO + "treino")
	public ModelAndView treinoPOST() {
		graphicalDataService.save(TipoDado.PAGINA_TREINO);
		Treino training = clientService.findByUser(getUser()).getTreino();

		return this.modelAndView(TRAINING_TIPS_PAGE).addObject("training", training);
	}

	@PostMapping(MAPPING_AVALIADO + "treino/adicionaDia")
	public ModelAndView adicionaDiaTreino(RedirectAttributes attributes) {
		Avaliado avaliado = clientService.findByUser(getUser());
		clientService.addDayTraining(avaliado);

		attributes.addFlashAttribute(SWEETMESSAGE_TAG, this.successMessage("Treino finalizado com sucesso."));
		return this.redirect("/avaliado/treino");
	}

}
