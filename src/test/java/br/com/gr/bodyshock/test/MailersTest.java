package br.com.gr.bodyshock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.service.AvaliadoService;
import br.com.gr.bodyshock.util.EnviaEmail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailersTest {

	@Autowired
	private EnviaEmail enviaEmail;

	@Autowired
	private AvaliadoService avaliadoService;

	@Test
	public void test() {
		Avaliado avaliado = this.avaliadoService.findById(3l);

		enviaEmail.confirmacaoCadastro(avaliado, "12345678");
		enviaEmail.confirmacaoValidacaoAvaliacao(avaliado);
		enviaEmail.redefinicaoSenha(avaliado.getUsuario());
	}

}
