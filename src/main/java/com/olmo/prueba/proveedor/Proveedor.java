package com.olmo.prueba.proveedor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.olmo.prueba.productos.Producto;

@Entity
public class Proveedor {

	
	@Id
	private String id;
	
	@Column
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="prov")
	List<Producto> productos = new ArrayList<Producto>();
	
	
	public void addProducto(Producto producto) {

		if(!productos.contains(producto)) {
			
			productos.add(producto);
		}
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}	
	
	
	
}
