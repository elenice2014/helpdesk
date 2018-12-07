package br.com.unip.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unip.helpdesk.model.Login;

public interface LoginRepository extends CrudRepository<Login, Long> {
	
}

