package br.com.unip.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unip.helpdesk.model.Etiqueta;

public interface EtiquetaRepository extends CrudRepository<Etiqueta, Long> {
	
	public Etiqueta findByCodigo(String codigo);


}
