package br.com.gr.bodyshock.mailers;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractMailer {

	protected String linkEmail = "bodyshocksystem@gmail.com";
	protected String linkSenha = "bsswolverine";
	
	@Value("${app.url}")
	protected String baseUrl;
	
	@Value("${owner.email}")
	protected String ownerEmail;
	
}
