package br.com.gr.bodyshock.conf;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.gr.bodyshock.model.Role;
import br.com.gr.bodyshock.model.Usuario;
import br.com.gr.bodyshock.repository.RoleRepository;
import br.com.gr.bodyshock.service.UserService;

@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService usuarioService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		if(roles.isEmpty()) {
			roleRepository.save(new Role("ROLE_ADMINISTRADOR"));
			roleRepository.save(new Role("ROLE_AVALIADO"));
			
			Usuario usuario = new Usuario();
			usuario.setDataCadastro(Calendar.getInstance());
			usuario.setEmail("admin@bodyshocksystem.com");
			usuario.setSenha(new BCryptPasswordEncoder().encode("038495psp2"));
			usuario.setNome("Administrador");
			
			usuarioService.save(usuario, "ROLE_ADMINISTRADOR");
		}
		
	}



}
