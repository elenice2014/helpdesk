package br.com.unip.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unip.helpdesk.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByCpfAndSenha(String cpf, String senha);

	Usuario findById(Integer id);

}

