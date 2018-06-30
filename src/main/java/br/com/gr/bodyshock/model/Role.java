package br.com.gr.bodyshock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "Role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	@Id
	private String nome;

	public Role() {
	} // JPA ONLY

	public Role(String role) {
		this.nome = role;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}

}
