package br.com.gr.bodyshock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.AnamnesisService;
import br.com.gr.bodyshock.service.PhysicalTestService;
import br.com.gr.bodyshock.service.ClientService;
import br.com.gr.bodyshock.service.DietService;
import br.com.gr.bodyshock.service.PerimetersService;
import br.com.gr.bodyshock.service.ResistenceTestService;
import br.com.gr.bodyshock.service.TrainingService;
import br.com.gr.bodyshock.service.UserService;

@Controller
public class ClientController extends AbstractController {

	private static final String SHOW_PAGE = "avaliado/show";
	private static final String INDEX_PAGE = "avaliado/index";

	@Autowired
	private ClientService avaliadoService;

	@Autowired
	private DietService dietaService;

	@Autowired
	private TrainingService treinoService;

	@Autowired
	private PerimetersService perimetrosService;

	@Autowired
	private PhysicalTestService avaliacaoService;

	@Autowired
	private ResistenceTestService testeResistenciaService;

	@Autowired
	private AnamnesisService anamneseService;

	@Autowired
	private UserService usuarioService;

	@GetMapping(MAPPING_ADMIN + "avaliado")
	public ModelAndView avaliados(Integer page) {
		if(page == null)
			page = 0;
		else if(page > 0)
			page -= 1;
		
		ModelAndView view = this.modelAndView(INDEX_PAGE);
		view.addObject("avaliados", avaliadoService.findByPageRequest(PageRequest.of(page, 10)));
		return view;
	}

	@GetMapping(MAPPING_ADMIN + "avaliado/{id}")
	public ModelAndView avaliadoDetalhe(@PathVariable Long id) {
		Avaliado avaliado = avaliadoService.findById(id);
		List<String> dietas = dietaService.findAllIds();
		List<String> treinos = treinoService.findAllIds();
		
		return this.modelAndView(SHOW_PAGE).addObject("avaliado", avaliado).addObject("dietas", dietas)
				.addObject("treinos", treinos);
	}

	@PostMapping(MAPPING_ADMIN + "avaliado/remover")
	public ModelAndView remover(@RequestParam long id, RedirectAttributes attributes) {
		String mensagem = null;
		try {
			Avaliado avaliado = this.avaliadoService.findById(id);

			for (Avaliacao avaliacao : avaliado.getAvaliacoes()) {
				this.perimetrosService.delete(avaliacao.getPerimetros());
				this.avaliacaoService.delete(avaliacao);
			}

			this.testeResistenciaService.delete(avaliado.getTesteResistencia());
			this.anamneseService.delete(avaliado.getAnamnese());
			this.usuarioService.delete(avaliado.getUsuario());
			this.avaliadoService.delete(avaliado);
			mensagem = this.successMessage("Avaliado removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage("Erro ao deletar avaliado.");
		}

		attributes.addFlashAttribute(SWEETMESSAGE_TAG, mensagem);
		return this.redirect("/dashboard");
	}

	@PostMapping(MAPPING_ADMIN + "/avaliado/horario/alteracao")
	public ModelAndView alteraHorario(@RequestParam Integer horaAcorda, @RequestParam Integer horaDorme,
			@RequestParam long idAvaliado, RedirectAttributes attributes) {

		String mensagem = null;

		try {
			Avaliado avaliado = this.avaliadoService.findById(idAvaliado);
			Avaliacao avaliacao = this.avaliacaoService.findByClientAndActivation(avaliado, Ativacao.ATIVA);
			this.avaliadoService.alterSchedule(avaliado,avaliacao, horaAcorda, horaDorme);
			mensagem = this.successMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}

		attributes.addFlashAttribute(SWEETMESSAGE_TAG, mensagem);
		return this.redirect("/dashboard");
	}
	
	@PostMapping(MAPPING_ADMIN + "/avaliado/dietaTreino/alteracao")
	public ModelAndView alteraDieta(@RequestParam String idDieta, @RequestParam String idTreino,
			@RequestParam long idAvaliado, RedirectAttributes attributes) {

		String mensagem = null;

		try {
			avaliadoService.changeDietAndTraining(idAvaliado, idDieta, idTreino);
			mensagem = this.successMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}

		attributes.addFlashAttribute(SWEETMESSAGE_TAG, mensagem);
		return this.redirect("/dashboard");
	}
	
}
