package br.com.unip.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.helpdesk.model.Endereco;
import br.com.unip.helpdesk.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository; // servico DAO

	public Endereco save(Endereco endereco){
	
		return repository.save(endereco);
	}

}

