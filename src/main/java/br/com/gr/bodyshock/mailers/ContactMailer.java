package br.com.gr.bodyshock.mailers;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.wrapper.ContatoWrapper;

@Service
public class ContactMailer extends AbstractMailer {

	public void send(ContatoWrapper contatoWrapper) {
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setAuthentication(linkEmail, linkSenha);
		try {
			email.setFrom(contatoWrapper.getEmail(), contatoWrapper.getNome());
			email.setDebug(true);
			email.setSubject("Contato - BodyShock");

			StringBuilder builder = new StringBuilder();
			builder.append("Contato de " + contatoWrapper.getNome() + "<br/>Email: " + contatoWrapper.getEmail()
					+ "<br/>Mensagem: " + contatoWrapper.getMensagem());

			email.setHtmlMsg(builder.toString());
			email.addTo(ownerEmail);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
