package com.utict.api.interfaces;

import java.util.Map;

public interface PersonajeService {
	public abstract Map<String,Object> consultaPersonajes(int numPagina);

	public Map<String,Object> consultaPersonajesFiltro(int numPagina,String nombre);
	
}//fin PersonajeService
