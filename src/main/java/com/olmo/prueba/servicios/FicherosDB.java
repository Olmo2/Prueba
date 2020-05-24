package com.olmo.prueba.servicios;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.olmo.prueba.distribuidor.Distribuidor;
import com.olmo.prueba.juego.Juego;
import com.olmo.prueba.juego.JuegoDAO;
import com.olmo.prueba.plataforma.Plataforma;

@Service
public class FicherosDB {
	
//	@Autowired
//	 private JuegoDAO juegoDAO;

	public void guardarListaJuegos(List<Juego> lista) throws
	IOException {
		byte[] file;
		Path ruta;
		OutputStream os;
		for(int i = 0; i<lista.size(); i++){
			if(lista.get(i).getImg()!=null) {
				file = lista.get(i).getImg();
			
			
			//Path ruta = Paths.get("D:\\Descargas\\esmeralda.jpg");
			 ruta = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\"+ lista.get(i).getRef() +".jpg");
			try {
				 os = Files.newOutputStream(ruta);
				os.write(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				System.out.println("no hay imagen para ti");
			}
		
		}
	}
	
	
		public void guardarListaPlataformas(List<Plataforma> lista) throws
		IOException {
			byte[] file;
			Path ruta;
			OutputStream os;
			for(int i = 0; i<lista.size(); i++){
				if(lista.get(i).getImg()!=null) {
					file = lista.get(i).getImg();
				
				
				//Path ruta = Paths.get("D:\\Descargas\\esmeralda.jpg");
				 ruta = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\"+ lista.get(i).getId() +".jpg");
				try {
					 os = Files.newOutputStream(ruta);
					os.write(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					System.out.println("no hay imagen para ti");
				}
			
			}
		}
		
		public void guardarListaDist(List<Distribuidor> lista) throws
		IOException {
			byte[] file;
			Path ruta;
			OutputStream os;
			for(int i = 0; i<lista.size(); i++){
				if(lista.get(i).getImg()!=null) {
					file = lista.get(i).getImg();
				
				
				//Path ruta = Paths.get("D:\\Descargas\\esmeralda.jpg");
				 ruta = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\"+ lista.get(i).getId() +".jpg");
				try {
					 os = Files.newOutputStream(ruta);
					os.write(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					System.out.println("no hay pana para ti");
				}
			
			}
		}
			}
		



	
