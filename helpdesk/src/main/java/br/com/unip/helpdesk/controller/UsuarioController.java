package br.com.unip.helpdesk.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.unip.helpdesk.model.Chamado;
import br.com.unip.helpdesk.model.Endereco;
import br.com.unip.helpdesk.model.Usuario;
import br.com.unip.helpdesk.service.ChamadoService;
import br.com.unip.helpdesk.service.EnderecoService;
import br.com.unip.helpdesk.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ChamadoService chamadoService;

	@RequestMapping(value = "salvarUsuario", method = RequestMethod.POST)
	public String salvar(@RequestParam("cpf") String cpf, @RequestParam("nomeCompleto") String nomeCompleto,
			@RequestParam("senha") String senha, @RequestParam("confirmSenha") String confirmacaoSenha,
			@RequestParam("email") String email, @RequestParam("cep") String cep,
			@RequestParam("logradouro") String logradouro, @RequestParam("numero") String numero,
			@RequestParam("cidade") String cidade, @RequestParam("estado") String estado, Model model) {

		
		Endereco end = new Endereco();
		end.setCep(cep);
		end.setLogradouro(logradouro);
		end.setNumero(Integer.parseInt(numero));
		end.setCidade(cidade);
		end.setUf(estado);
		
		
		Endereco endResult = enderecoService.save(end);
		
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		usuario.setNomeCompleto(nomeCompleto);
		usuario.setEmail(email);
		usuario.setDataCadastro(new Date());
		usuario.setSenha(senha);
		usuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setEndereco(endResult);
		

		if (service.save(usuario) != null) {
			 model.addAttribute("user", usuario);
			 System.out.println("Cadastro efetuado com sucesso");
			 return "chamados";
		} else {
			model.addAttribute("mensagem", "Erro ao cadastrar");
			System.out.println("Erro ao cadastrar");
			return "createScreen";

		}

	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST )
	public String login(@RequestParam("cpf") String cpf, @RequestParam("senha") String senha, Model model, HttpSession session) {
		
		Usuario user = new Usuario();
		user.setCpf(cpf);
		user.setSenha(senha);
		
		Usuario userResult = service.logar(user);
		
		if(userResult != null) {
			session.setAttribute("user", userResult);
			System.out.println("logado");
			
			
			Iterable<Chamado> chamados = chamadoService.obterTodos();
			
			model.addAttribute("chamados", chamados);
			
			return "chamados";
		} else {
			model.addAttribute("mensagem", "Dados não encontrados!");
			System.out.println("Dados não encontrados");
			return "loginScreen";
			
		}
		
	}

}
