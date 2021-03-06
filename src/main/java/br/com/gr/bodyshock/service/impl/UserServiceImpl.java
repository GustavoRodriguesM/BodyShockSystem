package br.com.gr.bodyshock.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.model.Role;
import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.repository.UserRepository;
import br.com.gr.bodyshock.service.UserService;
import br.com.gr.bodyshock.util.HashGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Usuario findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public void changePassword(Usuario usuario, String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setSenha(encoder.encode(senha));
		usuario.setToken(HashGenerator.md5(usuario.getEmail() + usuario.getSenha().hashCode()));
		userRepository.save(usuario);
	}

	@Override
	public Usuario findByToken(String token) {
		return this.userRepository.findByToken(token);
	}

	@Override
	public void save(Usuario usuario, String role) {
		if (usuario.getId() == null)
			usuario.setDataCadastro(Calendar.getInstance());
		
		usuario.setRoles(Arrays.asList(new Role(role)));
		usuario.setToken(HashGenerator.md5(usuario.getEmail() + usuario.getSenha().hashCode()));
		userRepository.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		this.userRepository.save(usuario);
	}

	@Override
	public Usuario findById(Long id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) this.userRepository.findAll();
	}

	@Override
	@Deprecated
	public void save(Usuario arg) {
	}

	@Override
	public void delete(Usuario usuario) {
		this.userRepository.delete(usuario);
	}
}
