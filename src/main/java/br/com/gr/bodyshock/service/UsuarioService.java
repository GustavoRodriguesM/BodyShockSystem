package br.com.gr.bodyshock.service;

import br.com.gr.bodyshock.model.Usuario;

public interface UsuarioService extends AbstractService<Usuario, Long> {

	void save(Usuario usuario, String role);

	void changePassword(Usuario usuario, String senha);

	Usuario findByEmail(String email);

	Usuario findByToken(String token);

}
