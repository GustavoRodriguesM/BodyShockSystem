package br.com.gr.bodyshock.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.enums.Sexo;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.enums.TipoAvaliacao;
import br.com.gr.bodyshock.enums.TipoDado;
import br.com.gr.bodyshock.exception.DietaTreinoException;
import br.com.gr.bodyshock.exception.HorarioException;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.AnamneseService;
import br.com.gr.bodyshock.service.AvaliacaoService;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.service.PerimetrosService;
import br.com.gr.bodyshock.service.RelatorioService;
import br.com.gr.bodyshock.service.TesteResistenciaService;
import br.com.gr.bodyshock.service.UsuarioService;
import br.com.gr.bodyshock.service.impl.DadoGraficoService;
import br.com.gr.bodyshock.util.EnviaEmail;
import br.com.gr.bodyshock.util.GeraSenha;
import br.com.gr.bodyshock.validator.AvaliadoAvaliacaoWrapperValidator;
import br.com.gr.bodyshock.wrapper.AvaliadoAvaliacaoWrapper;

@Controller
public class PhysicalAssessmentController extends AbstractController {

	private static final String PHYSICAL_ASSESSMENT_PAGE = "avaliacao/cadastro/opcao";
	private static final String PHYSICAL_ASSESSMENT_VALIDATION_PAGE = "avaliacao/validacao";
	private static final String PAGINA_AVALIACAO_ADIPOMETRO = "avaliacao/cadastro/adipometro";
	private static final String PAGINA_AVALIACAO_FITA_METRICA = "avaliacao/cadastro/fitametrica";
	private static final String PAGINA_AVALIACAO_DETALHE = "avaliacao/detalhe";
	private static final String PAGINA_AVALIACAO_FORM = "avaliacao/alteracaoForm";

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private AvaliadoService avaliadoService;

	@Autowired
	private AnamneseService anamneseService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TesteResistenciaService testeResistenciaService;

	@Autowired
	private DadoGraficoService dadoGraficoService;

	@Autowired
	private RelatorioService relatorioService;

	@Autowired
	private PerimetrosService perimetrosService;

	@Autowired
	private EnviaEmail enviaEmail;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@InitBinder("avaliadoAvaliacaoWrapper")
	protected void initAutoAvaliadoBinder(WebDataBinder binder) {
		binder.addValidators(new AvaliadoAvaliacaoWrapperValidator());
	}

	@GetMapping("cadastro/avaliacao")
	public ModelAndView avaliacao(AvaliadoAvaliacaoWrapper avaliadoAvaliacaoWrapper, HttpServletRequest request) {
		dadoGraficoService.save(TipoDado.PAGINA_AVALIACAO_COMUM);

		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null)
			ipAddress = request.getRemoteAddr();

		LOGGER.debug("IP " + ipAddress + " acessando a pagina de avaliação");

		return new ModelAndView(PHYSICAL_ASSESSMENT_PAGE).addObject("sexos", Sexo.values());
	}

	@GetMapping("cadastro/avaliacao/adipometro")
	public ModelAndView formAvaliacaoAdipometro(AvaliadoAvaliacaoWrapper avaliadoAvaliacaoWrapper) {
		return new ModelAndView(PAGINA_AVALIACAO_ADIPOMETRO).addObject("sexos", Sexo.values());
	}

	@GetMapping("cadastro/avaliacao/fita-metrica")
	public ModelAndView formAvaliacaoFitaMetrica(AvaliadoAvaliacaoWrapper avaliadoAvaliacaoWrapper) {
		return new ModelAndView(PAGINA_AVALIACAO_FITA_METRICA).addObject("sexos", Sexo.values());
	}

	@PostMapping("cadastro/avaliacao")
	public ModelAndView cadastro(@Valid AvaliadoAvaliacaoWrapper avaliadoAvaliacaoWrapper, BindingResult result,
			RedirectAttributes attributes) {
		Avaliado avaliado = avaliadoAvaliacaoWrapper.getAvaliado();
		Avaliacao avaliacao = avaliadoAvaliacaoWrapper.getAvaliacao();

		if (result.hasErrors() && avaliacao.getTipoAvaliacao() == TipoAvaliacao.ADIPOMETRO)
			return formAvaliacaoAdipometro(avaliadoAvaliacaoWrapper);
		else if (result.hasErrors() && avaliacao.getTipoAvaliacao() == TipoAvaliacao.FITA_METRICA)
			return formAvaliacaoFitaMetrica(avaliadoAvaliacaoWrapper);

		String mensagem = null;

		String senha = GeraSenha.getAlphanumericPassword(7);

		try {

			this.avaliadoService.calculatesFatPercentage(avaliado, avaliacao);
			this.avaliadoService.calculatesMeals(avaliado);

			if (!avaliacao.isCoaching())
				this.avaliadoService.directsDietAndTrainig(avaliado, avaliacao);

			this.avaliadoService.calculatesIdealFatPercentage(avaliado, avaliacao);
			this.avaliadoService.classifyResistenceTest(avaliado);

			avaliado.getUsuario().setSenha(this.encoder.encode(senha));
			usuarioService.save(avaliado.getUsuario(), "ROLE_AVALIADO");

			anamneseService.save(avaliado.getAnamnese());
			perimetrosService.save(avaliacao.getPerimetros());
			testeResistenciaService.save(avaliado.getTesteResistencia());

			avaliadoService.save(avaliado);
			avaliacaoService.save(avaliacao, avaliado, Status.PENDENTE);

			relatorioService.makeRegistrationReport(avaliacao);

			// enviaEmail.avisoAvaliacaoAdministrador(avaliado.getUsuario());
			enviaEmail.confirmacaoCadastro(avaliado, senha);
			mensagem = this.successMessage("Avaliação cadastrada com sucesso! Consulte seu email.");

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			mensagem = this.errorMessage("Email duplicado!");
		} catch (HorarioException e) {
			e.printStackTrace();
			mensagem = this.errorMessage("Horário de alimentação está fora dos padrões!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			mensagem = this.errorMessage(
					"Foi impossivel realizar os calculos da sua avaliação! Cadastre dados verdadeiros sobre seu corpo.");
		}

		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);
		return this.redirect("../login");

	}

	/*
	 * 
	 * ADMINISTRADOR
	 * 
	 */

	@GetMapping(MAPPING_ADMIN + "avaliacao")
	public ModelAndView validacaoForm() {
		List<Avaliacao> avaliacoes = avaliacaoService.findAll();
		Collections.reverse(avaliacoes);
		return this.modelAndView(PHYSICAL_ASSESSMENT_VALIDATION_PAGE).addObject("avaliacoes", avaliacoes);
	}

	@PostMapping(MAPPING_ADMIN + "avaliacao")
	public ModelAndView validacao(@RequestParam Long id, RedirectAttributes attributes) {
		Avaliacao avaliacao = avaliacaoService.findById(id);

		String mensagem = null;

		try {
			avaliacaoService.validate(avaliacao);
			relatorioService.makePhysicalTestValidationReport(avaliacao);
			if (avaliacao.getStatus() == Status.PAGO)
				enviaEmail.confirmacaoValidacaoAvaliacao(avaliacao.getAvaliado());
			mensagem = this.successMessage();
		} catch (DietaTreinoException e) {
			mensagem = this.errorMessage("É necessário cadastrar uma dieta e um treino antes de ativar a avaliação.");
		}

		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);
		return this.redirect("/admin/avaliacao");
	}

	@GetMapping(MAPPING_ADMIN + "avaliacao/{id}")
	public ModelAndView avaliacaoDetalhe(@PathVariable long id) {
		Avaliacao avaliacao = this.avaliacaoService.findById(id);
		return this.modelAndView(PAGINA_AVALIACAO_DETALHE).addObject("avaliacao", avaliacao);
	}

	@GetMapping(MAPPING_ADMIN + "avaliacao/altera/{id}")
	public ModelAndView avaliacaoForm(@PathVariable long id) {
		Avaliacao avaliacao = this.avaliacaoService.findById(id);
		return this.modelAndView(PAGINA_AVALIACAO_FORM).addObject("avaliacao", avaliacao);
	}

	@PostMapping(MAPPING_ADMIN + "avaliacao/altera")
	public ModelAndView avaliacaoAlteracao(Avaliacao avaliacao, RedirectAttributes attributes) {
		try {
			Avaliado avaliado = this.avaliadoService.findById(avaliacao.getAvaliado().getId());
			this.avaliadoService.calculatesFatPercentage(avaliado, avaliacao);
			if (!avaliacao.isCoaching())
				this.avaliadoService.directsDietAndTrainig(avaliado, avaliacao);

			this.avaliadoService.calculatesIdealFatPercentage(avaliado, avaliacao);

			this.perimetrosService.update(avaliacao.getPerimetros());
			this.avaliacaoService.update(avaliacao);
			this.avaliadoService.update(avaliado);

			attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, this.successMessage());
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, this.errorMessage());
		}

		return this.redirect("/admin/avaliacao/" + avaliacao.getId());
	}

}
