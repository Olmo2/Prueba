package com.olmo.prueba.juego;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olmo.prueba.distribuidor.Distribuidor;


@Repository
public interface JuegoDAO extends CrudRepository<Juego,Integer> {
	
	
		List<Juego> findAllByPlat_id(String Plat);
		List<Juego> findAllByDist_id(String Dist);
		List<Juego> findAllByDesa_id(String Desa);
	
	
	
}


