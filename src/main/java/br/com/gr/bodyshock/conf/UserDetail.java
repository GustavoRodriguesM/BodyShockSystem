package br.com.gr.bodyshock.conf;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.repository.UserRepository;

@Repository
@Transactional
public class UserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.userRepository.findByEmail(email);

		if (usuario == null)
			throw new RuntimeException("User " + email + " not found!");

		return usuario;
	}

}
