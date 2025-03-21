package br.com.caotica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Login controller class
 * @author Thiago Pinheiro do Nascimento
 * @since 20 mar 2025
**/
@Controller
public class LoginController {
	
	/**
	 * Login form action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 20 mar 2025
	**/
	@GetMapping("/login")
	public String login() {
		return "auths/login";
	}
}