package br.com.unip.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unip.helpdesk.model.Chamado;

public interface ChamadoRepository extends CrudRepository<Chamado, Long> {

	Chamado findById(Long id);
	
}

