package com.olmo.prueba.servicios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.olmo.prueba.juego.Juego;
import com.olmo.prueba.juego.JuegoDAO;


public class FicherosDB {
	
	@Autowired
	 private JuegoDAO juegoDAO;

	public Juego guardarFichero(MultipartFile file) throws
	IOException {
	 // Normalize file name
	 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	 // Check if the file's name contains invalid characters
	if(fileName.contains("..")) {
	 throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
	}
	Juego juego = new Juego();
	
	return juegoDAO.save(juego);
	 }

//	 public Juego getFichero(Long fileId) {
//
//	 return ficherosDAO.findById(fileId)
//	 .orElseThrow(() -> new StorageFileNotFoundException("File not found with id
//	" + fileId));
//	 }

}
