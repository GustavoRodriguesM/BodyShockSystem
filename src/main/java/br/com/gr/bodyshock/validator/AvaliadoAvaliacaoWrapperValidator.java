package br.com.gr.bodyshock.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gr.bodyshock.wrapper.AvaliadoAvaliacaoWrapper;

public class AvaliadoAvaliacaoWrapperValidator extends AbstractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AvaliadoAvaliacaoWrapper.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.usuario.nome", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.usuario.email", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.dataNascimento", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.horaAcorda", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.horaDorme", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.sexo", FIELD_REQUIRED);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.praticouMusculacao", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.doencaHereditaria", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.doencaPessoal", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.restricaoPraticaAtivFisica",
				FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.cirurgiaRecente", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.alergias", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.anamnese.fuma", FIELD_REQUIRED);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.pescoco", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.torax", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.cintura", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.quadril", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.abdomen", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.anteBracoD", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.anteBracoE", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.bicepsD", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.bicepsE", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.coxaD", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.coxaE", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.panturrilhaD", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.perimetros.panturrilhaE", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.peso", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliacao.altura", FIELD_REQUIRED);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.testeResistencia.abdominais", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "avaliado.testeResistencia.flexao", FIELD_REQUIRED);

		AvaliadoAvaliacaoWrapper avaliado = (AvaliadoAvaliacaoWrapper) target;
		Integer horaAcorda = avaliado.getAvaliado().getHoraAcorda();
		Integer horaDorme = avaliado.getAvaliado().getHoraDorme();

		if (((horaDorme - horaAcorda) / 3) < 5) {
			errors.rejectValue("avaliado.horaAcorda", HORA_INVALIDA);
		}

	}

}