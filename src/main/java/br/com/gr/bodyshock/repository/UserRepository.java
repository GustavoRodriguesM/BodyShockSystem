package br.com.gr.bodyshock.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gr.bodyshock.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long>{

	Usuario findByEmail(String email);

	Usuario findByToken(String token);

}
