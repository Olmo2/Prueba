package com.olmo.prueba.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmo.prueba.productos.Producto;


@Controller
public class RutasProveedor {

	
	@Autowired
	ProveedorDAO proveedorDAO;
	
	@GetMapping("/proveedores")
	public ModelAndView todoslosProveedores() {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("proveedores");
		mav.addObject("prov",new Producto());
		
		List<Proveedor> listaProveedores = (List<Proveedor>)proveedorDAO.findAll();
		mav.addObject("proveedores",listaProveedores);
		
		
		
		return mav;
	}
	
	@PostMapping("/proveedor/anadir")
	public String proveedorAnadir(@ModelAttribute Proveedor proveedor) {
		
		
		
		proveedorDAO.save(proveedor);
		
		return "redirect:/proveedores";
	}
	
	@GetMapping("/proveedores/borrar/{id}")
	public String proveedoresBorrar(@PathVariable String id) {
		
		proveedorDAO.deleteById(id);
		
		return "redirect:/proveedores";
	}
}
