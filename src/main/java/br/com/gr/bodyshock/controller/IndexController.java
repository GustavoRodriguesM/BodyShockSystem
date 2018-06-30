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
import br.com.gr.bodyshock.service.impl.DadoGraficoService;
import br.com.gr.bodyshock.util.EnviaEmail;
import br.com.gr.bodyshock.validator.ContatoValidator;
import br.com.gr.bodyshock.wrapper.ContatoWrapper;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private DadoGraficoService dadoGraficoService;

	@Autowired
	private EnviaEmail enviaEmail;

	private static final String INDEX_PAGE = "home/index";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ContatoValidator());
	}

	@GetMapping("")
	public ModelAndView index(ContatoWrapper contatoWrapper) {
		dadoGraficoService.save(TipoDado.PAGINA_HOME);
		return this.modelAndView(INDEX_PAGE);
	}

	@PostMapping("/contato")
	public ModelAndView contato(@Valid ContatoWrapper contatoWrapper, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors())
			return this.index(contatoWrapper);

		this.enviaEmail.emailContato(contatoWrapper);
		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, "Contato enviado com sucesso!");
		return this.redirect("/");
	}

}
