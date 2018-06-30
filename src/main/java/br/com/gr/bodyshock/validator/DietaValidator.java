package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.model.Dieta;

public class DietaValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Dieta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carbo1", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prot1", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "suplem1", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ref1", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ref2", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ref3", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ref4", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ref5", FIELD_REQUIRED);
		
			
	}

}
