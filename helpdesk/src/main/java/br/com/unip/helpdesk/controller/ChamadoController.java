package br.com.unip.helpdesk.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.unip.helpdesk.model.Chamado;
import br.com.unip.helpdesk.model.Usuario;
import br.com.unip.helpdesk.service.ChamadoService;

@Controller
public class ChamadoController {

	@Autowired
	private ChamadoService service;

	@RequestMapping(value = "abrirChamado", method = RequestMethod.POST)
	public String chamado(@RequestParam("codigo_equipamento_hidden") String codigo_equipamento,
			@RequestParam("descricao_equipamento_hidden") String descricao_equipamento,
			@RequestParam("descricao_detalhada") String descricao_detalhada, Model model, HttpSession session) {

		Usuario user = (Usuario) session.getAttribute("user");
		Chamado chamado = new Chamado();
		chamado.setCodigo_equipamento(codigo_equipamento);
		chamado.setDescricao_equipamento(descricao_equipamento);
		chamado.setDescricao_detalhada(descricao_detalhada);
		chamado.setDataAbertura(new Date());
		chamado.setAnalista(user.getNomeCompleto());
		chamado.setUsuario(String.valueOf(user.getId()));
		chamado.setProduto(descricao_equipamento);
		chamado.setStatus("status_ativo");

		Chamado chaResult = service.save(chamado);

		if (chaResult != null) {
			System.out.println("Chamado criado com sucesso");

			Iterable<Chamado> chamados = service.obterTodos();
			model.addAttribute("chamados", chamados);
			return "chamados";
		} else {
			model.addAttribute("mensagem", "Erro ao cadastrar");
			System.out.println("Erro ao criar chamado");
			return "novo_chamado";

		}

	}

	@RequestMapping(value = "pesquisarChamado", method = RequestMethod.POST)
	public String pesquisarChamado(@RequestParam("numero_chamado") String numero_chamado, Model model) {

		Chamado chamadoResult = service.pesquisar(Long.parseLong(numero_chamado));

		if (chamadoResult != null) {
			model.addAttribute("mensagem", "Seu chamado já foi resolvido!!");
			System.out.println("Chamado encontrado");
		} else {
			model.addAttribute("mensagem", "Chamado não encontrado!");
			System.out.println("Chamado não encontrado");

		}
		return "loginScreen";
	}

	@RequestMapping(value = { "/visualizarChamado" }, method = RequestMethod.GET)
	public String visualizarChamado(Model model, @RequestParam("numero_chamado") String numero_chamado, HttpSession session) {

		Chamado chamadoResult = service.pesquisar(Long.parseLong(numero_chamado));

		session.setAttribute("chamado", chamadoResult);
		model.addAttribute("chamado", chamadoResult);

		return "editar_chamado";
	}

	@RequestMapping(value = { "/editarChamado" }, method = RequestMethod.POST)
	public String editarChamado(Model model, @ModelAttribute("chamado") Chamado chamado, HttpSession session) {

		Chamado chamadoSession = (Chamado)session.getAttribute("chamado");
		
		chamadoSession.setDescricao_detalhada(chamado.getDescricao_detalhada());
		
		Chamado chaResult = service.save(chamadoSession);

		if (chaResult != null) {
			System.out.println("Chamado editado com sucesso");

			Iterable<Chamado> chamados = service.obterTodos();
			model.addAttribute("chamados", chamados);
			return "chamados";
		} else {
			model.addAttribute("mensagem", "Erro ao editar");
			System.out.println("Erro ao criar chamado");
			return "editar_chamado";

		}
	}

	@RequestMapping("/novo_chamado")
	public String novo_chamado() {
		return "novo_chamado";
	}

	@RequestMapping("/chamados")
	public String chamados(Model model) {
		Iterable<Chamado> chamados = service.obterTodos();
		model.addAttribute("chamados", chamados);
		return "chamados";
	}

}
