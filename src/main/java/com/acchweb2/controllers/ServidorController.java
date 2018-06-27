package com.acchweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acchweb2.models.Servidor;
import com.acchweb2.repository.ServidorRepository;

@Controller
public class ServidorController {
	
	@Autowired
	private ServidorRepository sr;
	
	@RequestMapping("/servidores")
	public ModelAndView listaServidores() {
		ModelAndView mv = new ModelAndView("servidor/index");
		Iterable<Servidor> servidores = sr.findAll();
		mv.addObject("servidores", servidores);
		
		return mv;
	}
	
	@RequestMapping(value="/cadastrarServidor", method=RequestMethod.GET)
	public String form() {
		return "servidor/formServidor";
	}
	
	@RequestMapping(value="/cadastrarServidor", method=RequestMethod.POST)
	public String form(Servidor servidor) {
		sr.save(servidor);
		return "redirect:/servidores";
	}
}
