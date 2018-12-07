package br.com.unip.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.helpdesk.model.Chamado;
import br.com.unip.helpdesk.repository.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository; // servico DAO

	public Chamado save(Chamado chamado) {
		return repository.save(chamado);
	}

	public Chamado pesquisar(Long id) {
		return repository.findById(id);
	}

	public Iterable<Chamado> obterTodos() {
		Iterable<Chamado> chamados = repository.findAll();

		return chamados;
	}
}
