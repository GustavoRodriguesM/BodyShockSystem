package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.wrapper.ContatoWrapper;

public class ContatoValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContatoWrapper.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mensagem", FIELD_REQUIRED);
	}

}
