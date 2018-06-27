package com.acchweb2.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acchweb2.models.Ocorrencia;
import com.acchweb2.models.Veiculo;
import com.acchweb2.repository.OcorrenciaRepository;
import com.acchweb2.repository.VeiculoRepository;

@Controller
public class OcorrenciaController {
	
	@Autowired
	private VeiculoRepository er;
	
	@Autowired
	private OcorrenciaRepository or;
	
	@RequestMapping("/ocorrencias")
	public ModelAndView listaOcorrencias() {
		ModelAndView mv = new ModelAndView("ocorrencia/index");
		Iterable<Ocorrencia> ocorrencias = or.findAll();
		mv.addObject("ocorrencias", ocorrencias);
		
		return mv;
	}
	
	@RequestMapping(value="/cadastrarOcorrencia", method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("ocorrencia/formOcorrencia");
		Iterable<Veiculo> veiculos = er.findAll();
		mv.addObject("veiculos", veiculos);
		
		return mv;
	}
	
	@RequestMapping(value="/cadastrarOcorrencia", method=RequestMethod.POST)
	public String formPost(
		@RequestParam("codVeiculo") long codVeiculo,
		@RequestParam("data") Date data
	) {
		Ocorrencia o = new Ocorrencia();
		o.setData(data);
		
		Veiculo v = er.findByCodVeiculo(codVeiculo);
		o.setVeiculo(v);
		o.setServidor(v.getServidor());
		
		or.save(o);
		
		return "redirect:/ocorrencias";
	}
}
