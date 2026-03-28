package com.utict.api.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utict.api.interfaces.PersonajeService;

@Controller
@RequestMapping("/personajes")
public class PersonajeController {

	private static final Log LOG=LogFactory.getLog(PersonajeController.class);
	
	@Autowired
	@Qualifier("personajeServiceImpl")
	private PersonajeService personajeService;
	
	
	@GetMapping("/listarPersonajes")
	public String consultaPersonajes(@RequestParam(name="numPag",required=false) String numPag, Model model) {
		LOG.info("[PersonajeController.consultaPersonajes()] numPag="+numPag);
		int numPagina = (numPag==null || numPag.equals(""))?1:Integer.parseInt(numPag);
		
		Map<String,Object> resultadosMap=personajeService.consultaPersonajes(numPagina);
	
		model.addAttribute("paginas", resultadosMap.get("paginas"));
		model.addAttribute("numPagina", resultadosMap.get("numPagina"));
		model.addAttribute("nombreFiltro", "");
		model.addAttribute("personajes", resultadosMap.get("personajes"));
		
		return "formulario_personajes";
	}//fin listarPersonajes
	
	@GetMapping("/listarPersonajesFiltro")
	public String consultaPersonajesFiltro(@RequestParam(name="numPag",required=false) String numPag, @RequestParam(name="nombreFiltro",required=false) String nombreFiltro, Model model) {
		LOG.info("[PersonajeController.consultaPersonajesFiltro()] numPag="+numPag+", nombreFiltro="+nombreFiltro);
		int numPagina = (numPag==null || numPag.equals(""))?1:Integer.parseInt(numPag);
		nombreFiltro= (nombreFiltro==null)?"":nombreFiltro;
		
		Map<String,Object> resultadosMap=personajeService.consultaPersonajesFiltro(numPagina,nombreFiltro);
		
		if(resultadosMap.containsKey("msjError")) {
			model.addAttribute("msjError",resultadosMap.get("msjError"));
		}else {
			model.addAttribute("paginas", resultadosMap.get("paginas"));
			model.addAttribute("numPagina", resultadosMap.get("numPagina"));
			model.addAttribute("nombreFiltro", nombreFiltro);
			model.addAttribute("personajes", resultadosMap.get("personajes"));
		}
		
		return "formulario_personajes";
	}//fin listarPersonajes
	
}//fin PersonajeController
