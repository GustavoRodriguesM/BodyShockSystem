package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.model.Treino;

public class TreinoValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Treino.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardio", FIELD_REQUIRED);
	}

}
