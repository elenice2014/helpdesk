package br.com.unip.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unip.helpdesk.model.Etiqueta;
import br.com.unip.helpdesk.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByEtiqueta(Etiqueta e);

}
