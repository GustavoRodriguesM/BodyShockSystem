package br.com.gr.bodyshock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gr.bodyshock.mailers.ForgotPasswordMailer;
import br.com.gr.bodyshock.mailers.PhysicalTestValidationMailer;
import br.com.gr.bodyshock.mailers.RegisterConfirmationMailer;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailersTest {

	@Autowired
	private RegisterConfirmationMailer registerConfirmationMailer;

	@Autowired
	private PhysicalTestValidationMailer physicalTestValidationMailer;

	@Autowired
	private ForgotPasswordMailer forgotPasswordMailer;

	@Autowired
	private ClientService avaliadoService;

	@Test
	public void test() {
		Avaliado avaliado = this.avaliadoService.findById(3l);

		registerConfirmationMailer.send(avaliado, "12345678");
		physicalTestValidationMailer.send(avaliado);
		forgotPasswordMailer.send(avaliado.getUsuario());
	}

}
