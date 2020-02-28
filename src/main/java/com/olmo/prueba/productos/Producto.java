package com.olmo.prueba.productos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import com.olmo.prueba.proveedor.Proveedor;

@Entity
public class Producto {

	
	@Id
	private String ref;
	
	@Column
	private String nombre;
	
	@Column
	private int stock;
	

	@ManyToOne(optional=true,fetch=FetchType.EAGER)
	private Proveedor prov = new Proveedor();
	
	

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + ref + ", nombre=" + nombre + ", stock=" + stock + ", prov="  + "]";
	}
	

	
	
	
	
	
	
}
