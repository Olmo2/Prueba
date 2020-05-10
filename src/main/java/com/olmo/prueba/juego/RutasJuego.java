package com.olmo.prueba.juego;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.olmo.prueba.plataforma.Plataforma;
import com.olmo.prueba.plataforma.PlataformaDAO;
import com.olmo.prueba.servicios.FicherosDB;

@Controller
public class RutasJuego {
	

	@Autowired
	private JuegoDAO juegoDAO;

	@Autowired
	private PlataformaDAO plataformaDAO;
	
//	@Autowired
//	private FicherosDB ficheroDB;
	
	@GetMapping("/")
	public String home() {
		
		return "redirect:/juegos";
	}

	@GetMapping("/juegos/{plataforma}")
	public ModelAndView productosPlataforma(@PathVariable String plataforma) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("juegos"); /* Nombre del html que se muestra */
		mav.addObject("juego", new Juego());
		List<Juego> listaProductos =new ArrayList<Juego>();
		
	
			if(plataforma.equals("null")){
				listaProductos = (List<Juego>) juegoDAO.findAllByPlat_id(null);
			}else {
				listaProductos = (List<Juego>) juegoDAO.findAllByPlat_id(plataforma);
			}
	
		
		mav.addObject("juegos", listaProductos);
		
		List<Plataforma> listaPlataformas = (List<Plataforma>) plataformaDAO.findAll();
		mav.addObject("plataformas", listaPlataformas);

//		ArrayList<Juego> lista=new ArrayList<Juego>();
//		lista= (ArrayList<Juego>) productoDAO.findAll();
//		System.out.println(lista);
//		System.out.println(productoDAO.findAll());
//		
		return mav;

	}

	@GetMapping("/juegos")
	public ModelAndView todosLosProductos() {
		byte[] file = juegoDAO.findById(13).get().getImg();
		//Path ruta = Paths.get("D:\\Descargas\\esmeralda.jpg");
		Path ruta = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\"+ 13 +".jpg");
		try {
			OutputStream os = Files.newOutputStream(ruta);
			os.write(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("juegos"); /* Nombre del html que se muestra */
		mav.addObject("juego", new Juego());
		
		List<Juego> listaJuegos = (List<Juego>) juegoDAO.findAll();
		mav.addObject("juegos", listaJuegos);

		List<Plataforma> listaPlataformas = (List<Plataforma>) plataformaDAO.findAll();
		mav.addObject("plataformas", listaPlataformas);

		ArrayList<Juego> lista = new ArrayList<Juego>();
		lista = (ArrayList<Juego>) juegoDAO.findAll();
		System.out.println(lista);
		System.out.println(juegoDAO.findAll());

		return mav;
	}

	@PostMapping("/juegos/anadir")
	public String juegosAnadir(@ModelAttribute Juego juego,@RequestParam(value="file") MultipartFile file) {
		System.out.println(juego.getPlat());
		Plataforma plataforma= new Plataforma();
		plataforma.setId(null);
		if(juego.getPlat().toString().equals("null")){
			juego.setPlat(plataforma);
		}
		System.out.println(file);
	//file.transferTo("/img");
		try {
			juego.setImg(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		juegoDAO.save(juego);

		return "redirect:/juegos";
	}

	@GetMapping("/juegos/borrar/{id}")
	public String juegosBorrar(@PathVariable Integer id) {

		juegoDAO.deleteById(id);

		return "redirect:/juegos";
	}

	@PostMapping("/juegos/editar")
	public String juegosEditar(@Valid Juego juego,
							Errors errores,
							/*ModelMap map*/
							@ModelAttribute("juego") Juego game
							
							) {
		System.out.println(game.getPlat().getId());
//		Juego game = new Juego();
//		
//		map.addAttribute("juego", game);
//		if(errores.hasErrors()) {
//
//			map.addAttribute("errors",errores.getAllErrors());
//
//			System.out.println(errores.getAllErrors());
//			return "redirect:/juegos";
//		}
		
		

		juegoDAO.save(game);

		return "redirect:/juegos";
	}

	@GetMapping("/juegos/editar/{id}")
	public String juegosEditar(@PathVariable Integer id, @ModelAttribute Juego juego) {

		juego = juegoDAO.findById(id).get();
		System.out.println(juego.getPlat().getId());

		return "/juegos/editar";
	}
	
	
//	//ruta fichero 
//	
//	@PostMapping("/addFichero")
//	public String handleFileUpload( @RequestParam("file") MultipartFile file) {
//
//	
//	try {
//	ficheroDB.guardarFichero(file);
//	}
//	catch (IOException e) {
//	e.printStackTrace();
//	}
//	 return "misco";
//	}


}
