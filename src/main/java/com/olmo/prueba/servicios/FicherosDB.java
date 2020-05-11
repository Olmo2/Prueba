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

import com.olmo.prueba.juego.Juego;
import com.olmo.prueba.juego.JuegoDAO;

@Service
public class FicherosDB {
	
//	@Autowired
//	 private JuegoDAO juegoDAO;

	public void guardarFichero(List<Juego> lista) throws
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
		
//	 // Normalize file name
//	 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	 // Check if the file's name contains invalid characters
//	if(fileName.contains("..")) {
//	 throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
//	}
//	Juego juego = new Juego();
//	
//	return juegoDAO.save(juego);
//	 }

//	 public Juego getFichero(Long fileId) {
//
//	 return ficherosDAO.findById(fileId)
//	 .orElseThrow(() -> new StorageFileNotFoundException("File not found with id
//	" + fileId));
//	 }

}
	}
