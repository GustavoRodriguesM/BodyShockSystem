package br.com.gr.bodyshock.mailers;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Avaliado;

@Service
public class RegisterConfirmationMailer extends AbstractMailer {

	@Autowired
	private JavaMailSender emailSender;

	@Async
	public void send(Avaliado client, String password) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setTo(client.getUsuario().getEmail());
			helper.setSubject("Confirmação de avaliação");
			helper.setText(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width'/><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/> <title>Confirmação de avaliação</title></head><body style='margin:0px; background: #f8f8f8; '><div width='100%' style='background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%; width: 100%; color: #514d6a;'> <div style='max-width: 700px; padding:50px 0; margin: 0px auto; font-size: 14px'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='padding: 40px; background: #fff;'> <table border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='border-bottom:1px solid #f6f6f6;'><h1 style='font-size:14px; font-family:arial; margin:0px; font-weight:bold;'>Olá "
							+ client.getUsuario().getNome()
							+ ",</h1> <p style='margin-top:0px; color:#bbbbbb;'>Agradecemos pelo cadastro no sistema.</p></td></tr><tr> <td style='padding:10px 0 30px 0;'><p style='text-align: center'> Seu cadastro foi realizado com sucesso e essas são suas informações para entrar em sua conta! </p></td></tr><tr> <td style='text-align: center'> <b>Login: "
							+ client.getUsuario().getEmail() + " <br/> Senha: " + password
							+ "<br/> </b> </td></tr></tbody> </table> <table> <tbody> <tr> <td> <center> <a href='"
							+ baseUrl
							+ "/login' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Clique aqui para ir direto para o login!</a> </center>A partir da confirmação do seu pagamento você terá acesso a todas as suas informações de treino e sugestão de dieta! </td></tr><tr> <td> <b>- Obrigado pelo contato.<br/>Equipe BodyShock System</b> </td></tr><tr> <td style='border-top:1px solid #f6f6f6; padding-top:20px; color:#777'>Se você está com problemas em clicar no botão/resetar sua senha, por favor, responda este email para que soluções sejam tomadas.</td></tr></tbody> </table> </div></div></div></body></html>",
					true);
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
