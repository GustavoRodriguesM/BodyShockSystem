package br.com.gr.bodyshock.mailers;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.wrapper.ContactWrapper;

@Service
public class ContactMailer extends AbstractMailer {

	@Autowired
	private JavaMailSender emailSender;

	public void send(ContactWrapper contactWrapper) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			helper.setTo(ownerEmail);
			helper.setSubject("Contato - BodyShock");
			helper.setText("Contato de " + contactWrapper.getName() + "<br/>Email: " + contactWrapper.getEmail()
					+ "<br/>Mensagem: " + contactWrapper.getMessage(), true);
			emailSender.send(message);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}

}
