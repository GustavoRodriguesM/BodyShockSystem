package br.com.gr.bodyshock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.enums.TipoDado;
import br.com.gr.bodyshock.mailers.ContactMailer;
import br.com.gr.bodyshock.service.impl.GraphicalDataService;
import br.com.gr.bodyshock.validator.ContactValidator;
import br.com.gr.bodyshock.wrapper.ContactWrapper;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private GraphicalDataService dadoGraficoService;

	@Autowired
	private ContactMailer contactMailer;

	private static final String INDEX_PAGE = "home/index";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ContactValidator());
	}

	@GetMapping("")
	public ModelAndView index(ContactWrapper contactWrapper) {
		dadoGraficoService.save(TipoDado.PAGINA_HOME);
		return this.modelAndView(INDEX_PAGE);
	}

	@PostMapping("/contato")
	public ModelAndView contato(@Valid ContactWrapper contactWrapper, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors())
			return this.index(contactWrapper);

		this.contactMailer.send(contactWrapper);
		attributes.addFlashAttribute(SWEETMESSAGE_TAG, "Contato enviado com sucesso!");
		return this.redirect("/");
	}

}
