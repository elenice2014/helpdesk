package br.com.unip.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpdeskController {
	
	
	@RequestMapping("/presentationScreen")
	public String presentationScreen(){
		return "presentationScreen";
	}

	@RequestMapping(value = "loginScreen", method = RequestMethod.GET)
	public String loginScreen(){
		return "loginScreen";
	}

	@RequestMapping("/createScreen")
	public String createScreen(){
		return "createScreen";
	}
	
}
