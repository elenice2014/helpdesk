package br.com.unip.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.helpdesk.model.Etiqueta;
import br.com.unip.helpdesk.model.Produto;
import br.com.unip.helpdesk.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository; // servico DAO

	public Produto findByEtiqueta(Etiqueta e) {
		return repository.findByEtiqueta(e);
	}

}
