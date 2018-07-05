package br.com.gr.bodyshock.mailers;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Usuario;

@Service
public class PhysicalTestAdminAlertMailer extends AbstractMailer{

	public void send(Usuario user) {

		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setAuthentication(linkEmail, linkSenha);
		try {
			email.setFrom(linkEmail, "BodyShock System");
			email.setDebug(true);
			email.setSubject("Nova avaliacao cadastrada");

			StringBuilder builder = new StringBuilder();
			builder.append(
					"<!DOCTYPE html><html><head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1'></head><body style='background: #f1f4f7 !important;font-size: 14px !important;color: #444444 !important;font-family: Verdana'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='width: 75%; margin: 0 auto;'> <div style='background-color: #fff;padding: 3px;margin: 0 auto;margin-bottom: 30px;'> <p style='text-align: justify;margin-left: 10%;margin-right: 10%'>Ol&aacute;, administrador!</p><div style=\"margin-left: 15%; margin-right: 15%\"> <p style='text-align: center'>Recentemente foi cadastrada uma avalia&ccedil;&atilde;o no sistema no nome de "
							+ user.getNome() + " - email: " + user.getEmail() + "! <br/>"
							+ "Para visualiza-la basta entrar neste <a href='http://www.bodyshocksystem.com/admin/avaliado/pagina/0'>link</a>.</p><p style='text-align: center'>Atenciosamente, BodyShock System.</p></div></div></div></body></html>");

			email.setHtmlMsg(builder.toString());
			email.addTo(ownerEmail);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
