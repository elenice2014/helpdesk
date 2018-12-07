package br.com.unip.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.helpdesk.model.Etiqueta;
import br.com.unip.helpdesk.repository.EtiquetaRepository;

@Service
public class EtiquetaService {

	@Autowired
	private EtiquetaRepository repository; // servico DAO

	public Etiqueta findByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

}
