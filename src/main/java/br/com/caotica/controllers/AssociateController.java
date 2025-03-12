package br.com.caotica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caotica.models.Associate;
import br.com.caotica.models.Gender;
import br.com.caotica.repositories.AssociateRepository;
import br.com.caotica.services.AssociateService;

import jakarta.validation.Valid;

/**
 * Associate controller class
 * @author Thiago Pinheiro do Nascimento
 * @version 06 mar 2025
**/
@Controller
@RequestMapping("/associates")
public class AssociateController {
	
	/**
	 * Dependency injection with the associate repository interface
	**/
	@Autowired
	private AssociateRepository associateRepository;
	
	/**
	 * Dependency injection with the associate service class
	**/
	@Autowired
	private AssociateService associateService;
	
	/**
	 * Associate listing action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@GetMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("associates/search");
		mv.addObject("associates", associateRepository.findAll());
		mv.addObject("menu", "associates");
		return mv;
	}
	
	/**
	 * Associate registration form action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@GetMapping("/new")
	public ModelAndView create(Associate associate) {
		ModelAndView mv = new ModelAndView("associates/create");
		mv.addObject("genders", Gender.values());
		mv.addObject("menu", "associates");
		return mv;
	}
	
	/**
	 * Associate registration action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@PostMapping("/new")
	public ModelAndView create(@Valid Associate associate, BindingResult result) {
		if(result.hasErrors())
			return create(associate);
		associateService.persist(associate);
		return new ModelAndView("redirect:/associates");
	}
	
	/**
	 * Associate edit form action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@GetMapping("/{id}/edit")
	public ModelAndView update(@PathVariable("id") Long id, Associate associate, boolean isInvalid) {
		ModelAndView mv = new ModelAndView("associates/update");
		if(!isInvalid)
			associate = associateService.findOrFail(id);
		mv.addObject("genders", Gender.values());
		mv.addObject("associate", associate);
		mv.addObject("menu", "associates");
		return mv;
		
	}
	
	/**
	 * Associate editing action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@PostMapping("/edit")
	public ModelAndView update(@Valid Associate associate, BindingResult result) {
		if(result.hasErrors())
			return update(associate.getId(), associate, true);
		associateService.persist(associate);
		return new ModelAndView("redirect:/associates");
	}
}