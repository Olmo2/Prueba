package com.olmo.prueba.proveedor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmo.prueba.productos.Producto;
import com.olmo.prueba.productos.ProductoDAO;


@Controller
public class RutasProveedor {

	
	@Autowired
	ProveedorDAO proveedorDAO;
	
	@Autowired
	ProductoDAO productoDAO;
	
	@GetMapping("/proveedores")
	public ModelAndView todoslosProveedores() {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("proveedores");
		mav.addObject("prov",new Producto());
		
		List<Proveedor> listaProveedores = (List<Proveedor>)proveedorDAO.findAll();
		mav.addObject("proveedores",listaProveedores);
		
		
		
		return mav;
	}
	
	@PostMapping("/proveedores/anadir")
	public String proveedorAnadir(@ModelAttribute Proveedor proveedor) {
		
		
		
		proveedorDAO.save(proveedor);
		
		return "redirect:/proveedores";
	}
	
	@GetMapping("/proveedores/borrar/{id}")
	public String proveedoresBorrar(@PathVariable String id) {
		Proveedor prov =proveedorDAO.findById(id).get();
		Proveedor pepe =proveedorDAO.findById("pepe").get();
		System.out.println(prov);
		List<Producto> listaPrevia=prov.getProductos();
		for( Producto prod : listaPrevia) {
			prod.setProv(pepe);
			System.out.println(prod);
			productoDAO.save(prod);
		}
		listaPrevia.clear();
		
		prov.setProductos(listaPrevia);
		System.out.println(prov);
		
		proveedorDAO.save(prov);
		
		
		proveedorDAO.deleteById(id);
		
		return "redirect:/proveedores";
	}
}
