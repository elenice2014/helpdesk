package br.com.unip.helpdesk.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.helpdesk.message.Response;
import br.com.unip.helpdesk.model.Chamado;
import br.com.unip.helpdesk.model.Etiqueta;
import br.com.unip.helpdesk.model.Produto;
import br.com.unip.helpdesk.service.ChamadoService;
import br.com.unip.helpdesk.service.EtiquetaService;
import br.com.unip.helpdesk.service.ProdutoService;


@RestController
@RequestMapping("/api/rest")
public class RestWebController {
	
	@Autowired
	private EtiquetaService etiquetaService;
	
	@Autowired
	private ChamadoService chamadoService;

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/validadeGarantia", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response validadeGarantia(@RequestBody Etiqueta etiqueta) {
		
		Produto produto = null;
		Integer codigo = null;
		Etiqueta etiquetaResult = etiquetaService.findByCodigo(etiqueta.getCodigo());

		if (etiquetaResult != null) {
			
			boolean validade = calcularValidadeEtiqueta(etiquetaResult);
			
			if(validade) {
				
				produto = produtoService.findByEtiqueta(etiquetaResult);
				System.out.println("Garantia valida");
				codigo = 1;
			} else {
				System.out.println("Garantia não valida");
				codigo = 2;
			}
			
		} else {
			System.out.println("Garantia não encontrada");
			codigo = 3;
		}
		
		// Create Response Object
		Response response = new Response(codigo, produto);
		return response;
	}
	
	@RequestMapping(value = "/buscaChamado", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response buscaChamado(@RequestBody Chamado chamado) {
		
		Chamado chamadoResult = chamadoService.pesquisar(chamado.getId());
		Integer codigo = null;
		
		if (chamadoResult != null) {
				codigo = 1;
		} else {
			codigo = 2;
		}
		
		// Create Response Object
		Response response = new Response(codigo, chamadoResult);
		return response;
	}
	
	
	
	public boolean calcularValidadeEtiqueta(Etiqueta etiqueta) {
		
		Date hoje = new Date();
		
		if(etiqueta.getDataFimGarantia().before(hoje)) {
			return false;
		} else {
			return true;
		}
				
	}

}
