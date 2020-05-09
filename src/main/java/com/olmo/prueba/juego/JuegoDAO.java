package com.olmo.prueba.juego;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JuegoDAO extends CrudRepository<Juego,Integer> {
	
	
		List<Juego> findAllByPlat_id(String Plat);
	
	
	
}


