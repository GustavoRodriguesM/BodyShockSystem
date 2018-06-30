package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.model.Usuario;

public class UsuarioAlteraSenhaValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", FIELD_REQUIRED);

		Usuario user = (Usuario) target;
		if (user.getSenha().length() < 7)
			errors.rejectValue("senha", SENHA_TAMANHO);

	}
}
