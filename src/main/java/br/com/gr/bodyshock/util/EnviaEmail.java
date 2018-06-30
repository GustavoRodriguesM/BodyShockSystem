package br.com.gr.bodyshock.util;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.wrapper.ContatoWrapper;

@Component
public class EnviaEmail {

	private String linkEmail = "bodyshocksystem@gmail.com";
	private String linkSenha = "bsswolverine";
	
	@Value("${app.url}")
	private String baseUrl;
	
	@Value("${owner.email}")
	private String ownerEmail;

	public void redefinicaoSenha(Usuario usuario) {
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setSSLOnConnect(true);
		htmlEmail.setHostName("smtp.gmail.com");
		htmlEmail.setSslSmtpPort("465");
		htmlEmail.setAuthentication(linkEmail, linkSenha);
		try {
			htmlEmail.setFrom(linkEmail, "BodyShock System");
			htmlEmail.setDebug(true);
			htmlEmail.setSubject("Redefinição de Senha");
			htmlEmail.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			StringBuilder builder = new StringBuilder();
			builder.append(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width'/><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/> <title>Resetar senha</title></head><body style='margin:0px; background: #f8f8f8; '><div width='100%' style='background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%; width: 100%; color: #514d6a;'> <div style='max-width: 700px; padding:50px 0; margin: 0px auto; font-size: 14px'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='padding: 40px; background: #fff;'> <table border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='border-bottom:1px solid #f6f6f6;'><h1 style='font-size:14px; font-family:arial; margin:0px; font-weight:bold;'>Olá "
							+ usuario.getNome()
							+ ",</h1> <p style='margin-top:0px; color:#bbbbbb;'>Aqui estão suas instruções para restaurar sua senha.</p></td></tr><tr> <td style='padding:10px 0 30px 0;'><p>Uma chamada foi recebida pelo sistema para alterar a senha vinculada a este email. Se você não fez esta requisição, apenas ignore esta mensagem. Se você teve problemas para entrar em sua conta, por favor altere sua senha:</p></tr></tbody> </table> <center> <a href='"
							+ baseUrl + "/redefine/senha/t/" + usuario.getToken()
							+ "' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Resetar senha</a> </center> <table> <tbody> <tr> <td> <b>- Obrigado pelo contato.<br/>Equipe BodyShock System</b> </td></tr><tr> <td style='border-top:1px solid #f6f6f6; padding-top:20px; color:#777'>Se você está com problemas em clicar no botão/resetar sua senha, por favor, responda este email para que soluções sejam tomadas.</td></tr></tbody> </table> </div></div></div></body></html>");
			htmlEmail.setHtmlMsg(builder.toString());
			htmlEmail.addTo(usuario.getEmail());
			htmlEmail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void confirmacaoCadastro(Avaliado avaliado, String senha) {

		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setCharset("utf-8");
		email.setAuthentication(linkEmail, linkSenha);
		try {
			email.setFrom(linkEmail, "BodyShock System");
			email.setDebug(true);
			email.setSubject("Confirmação de Avaliacao");
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			StringBuilder builder = new StringBuilder();
			builder.append(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width'/><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/> <title>Confirmação de avaliação</title></head><body style='margin:0px; background: #f8f8f8; '><div width='100%' style='background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%; width: 100%; color: #514d6a;'> <div style='max-width: 700px; padding:50px 0; margin: 0px auto; font-size: 14px'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='padding: 40px; background: #fff;'> <table border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='border-bottom:1px solid #f6f6f6;'><h1 style='font-size:14px; font-family:arial; margin:0px; font-weight:bold;'>Olá "
							+ avaliado.getUsuario().getNome()
							+ ",</h1> <p style='margin-top:0px; color:#bbbbbb;'>Agradecemos pelo cadastro no sistema.</p></td></tr><tr> <td style='padding:10px 0 30px 0;'><p style='text-align: center'> Seu cadastro foi realizado com sucesso e essas são suas informações para entrar em sua conta! </p></td></tr><tr> <td style='text-align: center'> <b>Login: "
							+ avaliado.getUsuario().getEmail() + " <br/> Senha: " + senha
							+ "<br/> </b> </td></tr></tbody> </table> <table> <tbody> <tr> <td> <center> <a href='"
							+ baseUrl
							+ "/login' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Clique aqui para ir direto para o login!</a> </center>A partir da confirmação do seu pagamento você terá acesso a todas as suas informações de treino e sugestão de dieta! </td></tr><tr> <td> <b>- Obrigado pelo contato.<br/>Equipe BodyShock System</b> </td></tr><tr> <td style='border-top:1px solid #f6f6f6; padding-top:20px; color:#777'>Se você está com problemas em clicar no botão/resetar sua senha, por favor, responda este email para que soluções sejam tomadas.</td></tr></tbody> </table> </div></div></div></body></html>");
			email.setHtmlMsg(builder.toString());
			email.addTo(avaliado.getUsuario().getEmail());
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void confirmacaoValidacaoAvaliacao(Avaliado avaliado) {

		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setAuthentication(linkEmail, linkSenha);
		try {
			email.setFrom(linkEmail, "BodyShock System");
			email.setDebug(true);
			email.setSubject("Pagamento confirmado");
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			StringBuilder builder = new StringBuilder();
			builder.append(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width'/><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/> <title>Confirmação de avaliação</title></head><body style='margin:0px; background: #f8f8f8; '><div width='100%' style='background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%; width: 100%; color: #514d6a;'> <div style='max-width: 700px; padding:50px 0; margin: 0px auto; font-size: 14px'> <div style='background: #222 !important; height: 60px !important; '> <div style='text-align: center'> <div style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important; '> <a style=' color: #fff !important; font-size: 20px !important; text-transform: uppercase !important; font-weight: 500 !important; height: 60px !important; padding-top: 18px !important; line-height: normal !important;'> <span style=' color: #E92922!important;'>Bodyshock</span>System</a> </div></div></div><div style='padding: 40px; background: #fff;'> <table border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='border-bottom:1px solid #f6f6f6;'><h1 style='font-size:14px; font-family:arial; margin:0px; font-weight:bold;'>Olá "
							+ avaliado.getUsuario().getNome()
							+ ",</h1> <p style='margin-top:0px; color:#bbbbbb;'>A partir de agora você tem acesso total em sua conta do BodyShock System.</p></td></tr><tr style='text-align: center'> <td> <h3 style='text-transform: uppercase;text-align: center; color: #E92922'>parabéns!</h3> </td></tr><tr> <td style='padding:10px 0 30px 0;'><p style='text-align: center'> Agora você pode entrar em sua conta para ter acesso ao programa BodyShock System de 10 semanas! Dicas de alimentação e treinos estão na barra à esquerda da página.</p><center> <a href='"
							+ baseUrl
							+ "/login' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Clique aqui para ir direto para o login!</a> </center> </td></tr></tbody> </table> <table> <tbody> <tr> <td> Nós recomendamos que você utilize suas senhas habituais! Para a redefinição de sua senha, clique no botão abaixo. <center> <a href='"
							+ baseUrl + "/redefine/senha/t/" + avaliado.getUsuario().getToken()
							+ "' style='display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #E92922; border-radius: 5px; text-decoration:none;'>Clique aqui para redenifir sua senha</a> </center> </td></tr><tr> <td> <b>- Obrigado pelo contato.<br/>Equipe BodyShock System</b> </td></tr><tr> <td style='border-top:1px solid #f6f6f6; padding-top:20px; color:#777'>Se você está com problemas em clicar no botão/resetar sua senha, por favor, responda este email para que soluções sejam tomadas.</td></tr></tbody> </table> </div></div></div></body></html>");
			email.setHtmlMsg(builder.toString());
			email.addTo(avaliado.getUsuario().getEmail());
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void avisoAvaliacaoAdministrador(Usuario usuario) {

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
							+ usuario.getNome() + " - email: " + usuario.getEmail() + "! <br/>"
							+ "Para visualiza-la basta entrar neste <a href='http://www.bodyshocksystem.com/admin/avaliado/pagina/0'>link</a>.</p><p style='text-align: center'>Atenciosamente, BodyShock System.</p></div></div></div></body></html>");

			email.setHtmlMsg(builder.toString());
			email.addTo(ownerEmail);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void emailContato(ContatoWrapper contatoWrapper) {
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