package com.acchweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acchweb2.models.Servidor;
import com.acchweb2.models.Veiculo;
import com.acchweb2.repository.ServidorRepository;
import com.acchweb2.repository.VeiculoRepository;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository er;
	
	@Autowired
	private ServidorRepository sr;
	
	@RequestMapping("/veiculos")
	public ModelAndView listaVeiculos() {
		ModelAndView mv = new ModelAndView("veiculo/index");
		Iterable<Veiculo> veiculos = er.findAll();
		mv.addObject("veiculos", veiculos);
		
		return mv;
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("veiculo/formVeiculo");
		Iterable<Servidor> servidores = sr.findAll();
		mv.addObject("servidores", servidores);
		
		return mv;
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.POST)
	public String formPost(
		@RequestParam("servidor") long servidor,
		@RequestParam("tipo") String tipo,
		@RequestParam("modelo") String modelo,
		@RequestParam("fabricante") String fabricante,
		@RequestParam("placa") String placa,
		@RequestParam("cor") String cor
	) {
		Veiculo v = new Veiculo();
		v.setTipo(tipo);
		v.setModelo(modelo);
		v.setFabricante(fabricante);
		v.setPlaca(placa);
		v.setCor(cor);
		
		Servidor s = sr.findByCodServidor(servidor);
		v.setServidor(s);
		
		er.save(v);
		
		return "redirect:/veiculos";
	}
}
