package com.olmo.prueba.productos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoDAO extends CrudRepository<Producto,String> {
	
	
}


