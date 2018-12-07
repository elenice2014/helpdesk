package br.com.unip.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.helpdesk.model.Usuario;
import br.com.unip.helpdesk.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository; // servico DAO

	public Usuario save(Usuario usuario){
	
		return repository.save(usuario);
	}
	
	public Usuario logar(Usuario user) {
		return repository.findByCpfAndSenha(user.getCpf(), user.getSenha());
	}

	public Usuario userById(Integer id) {
		return repository.findById(id);
	}

}
