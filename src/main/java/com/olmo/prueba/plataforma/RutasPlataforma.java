package com.olmo.prueba.plataforma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmo.prueba.juego.Juego;
import com.olmo.prueba.juego.JuegoDAO;


@Controller
public class RutasPlataforma {

	
	@Autowired
	PlataformaDAO plataformaDAO;
	
	@Autowired
	JuegoDAO juegoDAO;
	
	@GetMapping("/plataformas")
	public ModelAndView todoslosProveedores() {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("plataformas");
		mav.addObject("plat",new Plataforma());
		
		List<Plataforma> listaPlataformas = (List<Plataforma>)plataformaDAO.findAll();
		mav.addObject("plataformas",listaPlataformas);
		
		
		
		return mav;
	}
	
	@PostMapping("/plataformas/anadir")
	public String proveedorAnadir(@ModelAttribute Plataforma plataforma) {

		plataformaDAO.save(plataforma);
		
		return "redirect:/plataformas";
	}
	
	@GetMapping("/plataformas/borrar/{id}")
	public String proveedoresBorrar(@PathVariable String id) {

		plataformaDAO.deleteById(id);
		
		return "redirect:/plataformas";
	}
}
