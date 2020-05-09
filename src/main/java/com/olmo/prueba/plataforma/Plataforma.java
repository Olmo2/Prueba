package com.olmo.prueba.plataforma;

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

import com.olmo.prueba.juego.Juego;


@Entity
public class Plataforma {

	@Id
	private String id;
	
	@Column
	private String nombre;

	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "plat")
	List<Juego> juegos = new ArrayList<Juego>();

	public void addProducto(Juego juego) {

		if (!juegos.contains(juego)) {

			juegos.add(juego);
		}
	}
	

	@PreRemove
	public final void reasignarPlataforma() {
		System.out.println("Destrucción");
		// recorrer la lista de usuarios reasignando los roles
		for (Juego juego : juegos) {

			juego.setPlat(null);
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



	public List<Juego> getJuegos() {
		return juegos;
	}


	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}


	

	@Override
	public String toString() {
		return id ;
	}
	

}
