package com.utict.api.model;

public class Personaje {
	
	private String id;
    private String nombre;
    private String especie;
    private String imagen;
      
    
    public Personaje() {
		// TODO Auto-generated constructor stub
	}
	

	public Personaje(String id, String nombre, String especie, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.imagen = imagen;
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


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", imagen=" + imagen + "]";
	}


    
}
