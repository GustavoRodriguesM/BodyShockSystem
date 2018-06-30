package br.com.gr.bodyshock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gr.bodyshock.model.Usuario;
import br.com.gustavorodrigues.alertmessage.enums.TypeMessage;
import br.com.gustavorodrigues.alertmessage.exception.RapidMessageException;
import br.com.gustavorodrigues.alertmessage.templates.SweetAlertMessage;

public abstract class AbstractController {

	Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
	
	private static final String MENSAGEM_SUCESSO = "Ação realizada com sucesso!";
	private static final String MENSAGEM_ERRO = "Erro ao executar ação!";
	
	static final String CAMPO_SWEETMESSAGE = "sweetAlert";
	static final String ROLE_PREFIX = "ROLE_";
	static final String MAPPING_ADMIN = "admin/";
	static final String MAPPING_AVALIADO = "avaliado/";

	private final SweetAlertMessage sweetAlertMessage = new SweetAlertMessage();

	protected String successMessage() {
		try {
			return this.sweetAlertMessage.showMessage(MENSAGEM_SUCESSO, TypeMessage.SUCCESS);
		} catch (RapidMessageException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String errorMessage() {
		try {
			return this.sweetAlertMessage.showMessage(MENSAGEM_ERRO, TypeMessage.DANGER);
		} catch (RapidMessageException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String successMessage(String mensagem) {
		try {
			return this.sweetAlertMessage.showMessage(mensagem, TypeMessage.SUCCESS);
		} catch (RapidMessageException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String errorMessage(String mensagem) {
		try {
			return this.sweetAlertMessage.showMessage(mensagem, TypeMessage.DANGER);
		} catch (RapidMessageException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected ModelAndView modelAndView(String view) {
		final ModelAndView modelAndView = new ModelAndView(view);
		return modelAndView;
	}

	protected ModelAndView redirect(String url) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView(url));
		return modelAndView;
	}

	protected Usuario getUser() {
		final Authentication authentication = this.getAuthentication();

		if (authentication != null) {
			final Object principal = authentication.getPrincipal();
			if (principal instanceof Usuario)
				return ((Usuario) principal).getUser();

			return null;
		}

		return null;
	}

	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	protected boolean hasRole(String role) {
		for (final GrantedAuthority g : this.getAuthentication().getAuthorities()) {
			if (g.getAuthority().equals(role)) {
				return true;
			}
		}
		return false;
	}
}