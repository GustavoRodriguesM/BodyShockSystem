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
import br.com.gr.bodyshock.model.Dieta;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.service.DietaService;
import br.com.gr.bodyshock.service.impl.DadoGraficoService;
import br.com.gr.bodyshock.validator.DietaValidator;

@Controller
public class DietController extends AbstractController {

	private static final String FORM_PAGE = "dieta/form";
	private static final String INDEX_PAGE = "dieta/index";

	private static final String FEEDING_TIPS_PAGE = "dieta/feeding-tips";

	@Autowired
	private DietaService dietaService;

	@Autowired
	private AvaliadoService avaliadoService;

	@Autowired
	private DadoGraficoService dadoGraficoService;

	@InitBinder("dieta")
	private void initDietaBinder(WebDataBinder binder) {
		binder.addValidators(new DietaValidator());
	}

	@GetMapping(MAPPING_ADMIN + "dieta")
	public ModelAndView lista() {
		return this.modelAndView(INDEX_PAGE).addObject("dietas", this.dietaService.findAllWithoutDefault());
	}

	@GetMapping(MAPPING_ADMIN + "dieta/form")
	public ModelAndView form(Dieta dieta) {
		return this.modelAndView(FORM_PAGE);
	}

	@GetMapping(MAPPING_ADMIN + "dieta/form/{id}")
	public ModelAndView formAlteracao(@PathVariable String id) {
		Dieta dieta = this.dietaService.findById(id);
		return this.modelAndView(FORM_PAGE).addObject("dieta", dieta);
	}

	@GetMapping(MAPPING_ADMIN + "dieta/remove/{id}")
	public ModelAndView remove(@PathVariable String id, RedirectAttributes attributes) {
		String mensagem = null;
		try {
			Dieta dieta = this.dietaService.findById(id);
			this.dietaService.delete(dieta);
			mensagem = this.successMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}
		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);

		return this.redirect("/admin/dieta");
	}

	@PostMapping(MAPPING_ADMIN + "dieta")
	public ModelAndView cadastro(@Valid Dieta dieta, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors())
			return form(dieta);

		String mensagem = null;

		try {
			dietaService.save(dieta);
			mensagem = this.successMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}

		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);
		return this.redirect("/admin/dieta");
	}

	/*
	 * AVALIADO
	 */

	@GetMapping(MAPPING_AVALIADO + "dicas-alimentacao")
	public ModelAndView feedingTips() {
		Avaliado client = avaliadoService.findByUser(getUser());
		dadoGraficoService.save(TipoDado.PAGINA_DIETA);
		return new ModelAndView(FEEDING_TIPS_PAGE).addObject("client", client);
	}

}
