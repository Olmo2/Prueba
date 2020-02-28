package com.olmo.prueba.proveedor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.olmo.prueba.productos.Producto;


@Entity
public class Proveedor {

	@Id
	private String nombre = "PROVEEDOR";

	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "prov")
	List<Producto> productos = new ArrayList<Producto>();

	public void addProducto(Producto producto) {

		if (!productos.contains(producto)) {

			productos.add(producto);
		}
	}
	

	@PreRemove
	public final void reasignarProveedor() {
		System.out.println("Destrucción");
		// recorrer la lista de usuarios reasignando los roles
		for (Producto prod : productos) {

			prod.setProv(null);
		}
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


	@Override
	public String toString() {
		return nombre ;
	}
	

}
