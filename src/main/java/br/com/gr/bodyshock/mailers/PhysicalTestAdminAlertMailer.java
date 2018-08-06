package br.com.gr.bodyshock.mailers;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Usuario;

@Service
public class PhysicalTestAdminAlertMailer extends AbstractMailer {

	@Autowired
	private JavaMailSender emailSender;

	@Async
	public void send(Usuario user) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setTo(ownerEmail);
			helper.setSubject("Nova avaliação cadastrada");
			helper.setText(
					"<!DOCTYPE html><html><head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1'></head><body style='background: #f1f4f7 !important;font-size: 14px !important;color: #444444 !important;font-family: Verdana'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='width: 75%; margin: 0 auto;'> <div style='background-color: #fff;padding: 3px;margin: 0 auto;margin-bottom: 30px;'> <p style='text-align: justify;margin-left: 10%;margin-right: 10%'>Ol&aacute;, administrador!</p><div style=\\\"margin-left: 15%; margin-right: 15%\\\"> <p style='text-align: center'>Recentemente foi cadastrada uma avalia&ccedil;&atilde;o no sistema no nome de \"\n"
							+ user.getNome() + " - email: " + user.getEmail()
							+ "! <br/>\nPara visualiza-la basta entrar neste <a href='http://www.bodyshocksystem.com/admin/avaliado/pagina/0'>link</a>.</p><p style='text-align: center'>Atenciosamente, BodyShock System.</p></div></div></div></body></html>",
					true);
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
