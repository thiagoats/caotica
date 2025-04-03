package br.com.caotica.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Home controller unit test class
 * @author Thiago Pinheiro do Nascimento
 * @since 27 mar 2025
**/
@SpringBootTest
public class HomeControllerTest {

	/**
	 * Spring mvc test support 
	**/
	private MockMvc mockMvc;
	
	/**
	 * Dependency injection with the home controller class
	**/
	@Autowired
	private HomeController homeController;
	
	/**
	 * Configuration performed before each test
	 * @author Thiago Pinheiro do Nascimento
	 * @since 27 mar 2025
	**/
	@BeforeEach
	public void setup() {
		this.mockMvc = standaloneSetup(homeController)
			.build();
	}
	
	/**
	 * It should return to the home page containing an attribute called model whose value is home
	 * @author Thiago Pinheiro do Nascimento
	 * @since 27 mar 2025
	**/
	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/"))
		.andDo(print()).andExpectAll(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attribute("model", "home"));
	}
}