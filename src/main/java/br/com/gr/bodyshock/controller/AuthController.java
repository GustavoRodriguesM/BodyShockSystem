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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.service.UserService;
import br.com.gr.bodyshock.util.EnviaEmail;
import br.com.gr.bodyshock.validator.UsuarioAlteraSenhaValidator;

@Controller
public class AuthController extends AbstractController {

	private static final String LOGIN_PAGE = "auth/login";

	private static final String RESTORE_PASSWORD_1_PAGE = "auth/envioEmail";
	private static final String RESTORE_PASSWORD_2_PAGE = "auth/redefineSenha";

	@Autowired
	private EnviaEmail enviaEmail;

	@Autowired
	private UserService usuarioService;

	@InitBinder(value = { "usuario" })
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioAlteraSenhaValidator());
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView(LOGIN_PAGE);
	}

	@GetMapping("/redefine/senha")
	public String formRecebeEmail() {
		return RESTORE_PASSWORD_1_PAGE;
	}

	@PostMapping("/redefine/senha")
	public ModelAndView recebeEmail(@RequestParam String email, RedirectAttributes attributes) {
		Usuario usuario = usuarioService.findByEmail(email);
		enviaEmail.redefinicaoSenha(usuario);
		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE,
				this.successMessage("Mensagem enviada para seu email caso tenha sido encontrado!"));
		return this.redirect("/login");
	}

	@GetMapping("/redefine/senha/t/{token}")
	public ModelAndView formRedefineSenha(@PathVariable String token, Usuario usuario) {
		return this.modelAndView(RESTORE_PASSWORD_2_PAGE);
	}

	@PostMapping("/redefine/senha/t")
	public ModelAndView redefineSenha(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors())
			return this.formRedefineSenha(usuario.getToken(), usuario);

		Usuario usuario1 = usuarioService.findByToken(usuario.getToken());

		String mensagem = null;

		try {
			usuarioService.changePassword(usuario1, usuario.getSenha());
			mensagem = this.successMessage("Senha alterada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = this.errorMessage();
		}

		attributes.addFlashAttribute(CAMPO_SWEETMESSAGE, mensagem);
		return this.redirect("/login");
	}

}