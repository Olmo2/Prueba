package com.olmo.prueba.juego;

import java.io.File;
import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.olmo.prueba.plataforma.Plataforma;

@Entity
public class Juego {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ref;
	
	@Lob
	private byte[] img;

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Column
	private String nombre;
	
	@Column
	@Size(min=1,max=2)
	private String pegi;
	
	@Column
	private String anio;
	

	@ManyToOne(optional=true,fetch=FetchType.EAGER)
	private Plataforma plat = new Plataforma();
	
	


	public Integer getRef() {
		return ref;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public Plataforma getPlat() {
		return plat;
	}

	public void setPlat(Plataforma plat) {
		this.plat = plat;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String pegi) {
		this.pegi = pegi;
	}



	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Juego [ref=" + ref + ", img=" + img + ", nombre=" + nombre + ", pegi=" + pegi
				+ ", anio=" + anio + ", plat=" + plat + "]";
	}

	
	
	

	
	

	
	
	
	
	
	
}
