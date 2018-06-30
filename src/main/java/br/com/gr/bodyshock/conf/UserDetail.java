package br.com.gr.bodyshock.conf;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.repository.UsuarioRepository;

@Repository
@Transactional
public class UserDetail implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email);

		if (usuario == null)
			throw new RuntimeException("Usuario " + email + " não encontrado!");

		return usuario;
	}

}
