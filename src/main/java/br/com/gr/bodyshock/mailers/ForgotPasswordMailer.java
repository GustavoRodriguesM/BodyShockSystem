package br.com.gr.bodyshock.mailers;

import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Usuario;

@Service
public class ForgotPasswordMailer extends AbstractMailer {

	public void send(Usuario user) {
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setSSLOnConnect(true);
		htmlEmail.setHostName("smtp.gmail.com");
		htmlEmail.setSslSmtpPort("465");
		htmlEmail.setAuthentication(linkEmail, linkSenha);
		try {
			htmlEmail.setFrom(linkEmail, "BodyShock System");
			htmlEmail.setDebug(true);
			htmlEmail.setSubject("Redefinição de Senha");
			htmlEmail.setCharset(EmailConstants.UTF_8);
			StringBuilder builder = new StringBuilder();
			builder.append(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width'/><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/> <title>Resetar senha</title></head><body style='margin:0px; background: #f8f8f8; '><div width='100%' style='background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%; width: 100%; color: #514d6a;'> <div style='max-width: 700px; padding:50px 0; margin: 0px auto; font-size: 14px'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='padding: 40px; background: #fff;'> <table border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='border-bottom:1px solid #f6f6f6;'><h1 style='font-size:14px; font-family:arial; margin:0px; font-weight:bold;'>Olá "
							+ user.getNome()
							+ ",</h1> <p style='margin-top:0px; color:#bbbbbb;'>Aqui estão suas instruções para restaurar sua senha.</p></td></tr><tr> <td style='padding:10px 0 30px 0;'><p>Uma chamada foi recebida pelo sistema para alterar a senha vinculada a este email. Se você não fez esta requisição, apenas ignore esta mensagem. Se você teve problemas para entrar em sua conta, por favor altere sua senha:</p></tr></tbody> </table> <center> <a href='"
							+ baseUrl + "/redefine/senha/t/" + user.getToken()
							+ "' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Resetar senha</a> </center> <table> <tbody> <tr> <td> <b>- Obrigado pelo contato.<br/>Equipe BodyShock System</b> </td></tr><tr> <td style='border-top:1px solid #f6f6f6; padding-top:20px; color:#777'>Se você está com problemas em clicar no botão/resetar sua senha, por favor, responda este email para que soluções sejam tomadas.</td></tr></tbody> </table> </div></div></div></body></html>");
			htmlEmail.setHtmlMsg(builder.toString());
			htmlEmail.addTo(user.getEmail());
			htmlEmail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
