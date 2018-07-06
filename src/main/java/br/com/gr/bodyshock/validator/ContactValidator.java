package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.wrapper.ContactWrapper;

public class ContactValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactWrapper.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", FIELD_REQUIRED);
	}

}
