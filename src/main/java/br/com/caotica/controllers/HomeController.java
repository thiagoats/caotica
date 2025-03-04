package br.com.caotica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller
 * @author Thiago Pinheiro do Nascimento
 * @since 20 feb 2025
**/
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * Index get action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 20 feb 2025
	**/
	@GetMapping
	public String index() {
		return "index";
	}
}