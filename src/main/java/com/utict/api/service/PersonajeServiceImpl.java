package com.utict.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.utict.api.configuration.ConfigWebClient;
import com.utict.api.exception.RecursoNoEncontradoException;
import com.utict.api.interfaces.PersonajeService;
import com.utict.api.model.Personaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("personajeServiceImpl")
public class PersonajeServiceImpl implements PersonajeService{

    private final ConfigWebClient configWebClient;
	
	private static final Log LOG=LogFactory.getLog(PersonajeServiceImpl.class);
	
	@Autowired
	private WebClient webClient;

    PersonajeServiceImpl(ConfigWebClient configWebClient) {
        this.configWebClient = configWebClient;
    }
    
	public Map<String,Object> consultaPersonajes(int numPagina) {
		LOG.info("[PersonajeServiceImpl.consultaPersonajes()] ");
		
		String uri= (numPagina==1)?"/character":"/character/?page="+numPagina;
		
		JsonNode personajesJson=webClient.get().uri(uri).retrieve().bodyToMono(JsonNode.class).block();  

		int paginas=personajesJson.get("info").get("pages").asInt();
		//boolean results=personajesJson.get("results").isArray();
		//LOG.info("[PersonajeServiceImpl.consultaPersonajes()] paginas="+paginas+" results="+results);
		//personajesJson.get("results").forEach( p -> LOG.info(p.get("name")+" "+p.get("species")+" "+p.get("image"))  );
		
		Map<String,Object> resultadosMap=new HashMap<String,Object>();
		resultadosMap.put("paginas", paginas);
		resultadosMap.put("numPagina", numPagina);
		
		List<Personaje> personajesList=new ArrayList<Personaje>();
		personajesJson.get("results").forEach( p -> personajesList.add(new Personaje(p.get("id").asText(),p.get("name").asText(),p.get("species").asText(),p.get("image").asText()))
		                                       );
		//System.out.println(personajesList);		
		resultadosMap.put("personajes", personajesList);
		
		return resultadosMap;
		
	}//fin consultaPersonajes
	
	public Map<String,Object> consultaPersonajesFiltro(int numPagina,String nombre) {
		LOG.info("[PersonajeServiceImpl.consultaPersonajes()] ");
		
		String uri= "/character/?page="+numPagina+"&name="+nombre;
		LOG.info("[PersonajeServiceImpl.consultaPersonajes()] uri="+uri);
		
		JsonNode personajesJson=webClient.get()
				                         .uri(uri)
				                         .retrieve()
				                         .onStatus(status -> status.value() == 404,response -> Mono.error(new RecursoNoEncontradoException("No hay nada que mostrar")))				                     
				                         .bodyToMono(JsonNode.class)
				                         .onErrorResume(RecursoNoEncontradoException.class, e -> {
				                             // Loguear error o devolver un JsonNode vacío/alternativo
				                        	 LOG.info("[PersonajeServiceImpl.consultaPersonajes()] No hay nada que mostrar");
				                        	 ObjectMapper mapper = new ObjectMapper();
				                             
				                             ObjectNode nodo = mapper.createObjectNode();
				                             
				                             nodo.put("error", "No hay nada que mostrar");
				                             LOG.info("[PersonajeServiceImpl.consultaPersonajes()"+nodo.toPrettyString());
				                             
				                             return Mono.just(nodo);
				                         })
				                         .block();  

		//boolean results=personajesJson.get("results").isArray();
		//LOG.info("[PersonajeServiceImpl.consultaPersonajes()] paginas="+paginas+" results="+results);
		//personajesJson.get("results").forEach( p -> LOG.info(p.get("name")+" "+p.get("species")+" "+p.get("image"))  );
		
		Map<String,Object> resultadosMap=new HashMap<String,Object>();
		
		
		if(personajesJson.has("error")) {
			LOG.info("[PersonajeServiceImpl.consultaPersonajes()] error="+personajesJson.get("error").asText());
			String msjError=personajesJson.get("error").asText();
			resultadosMap.put("msjError", msjError);
		}else {
			int paginas=personajesJson.get("info").get("pages").asInt();
			LOG.info("[PersonajeServiceImpl.consultaPersonajes()] paginas="+paginas);
			
			resultadosMap.put("paginas", paginas);
			resultadosMap.put("numPagina", numPagina);
			
			List<Personaje> personajesList=new ArrayList<Personaje>();
			personajesJson.get("results").forEach( p -> personajesList.add(new Personaje(p.get("id").asText(),p.get("name").asText(),p.get("species").asText(),p.get("image").asText()))
			                                       );
			//System.out.println(personajesList);		
			resultadosMap.put("personajes", personajesList);
		}
		
		
		return resultadosMap;
		
	}//fin consultaPersonajesFiltro
	
}//PersonajeServiceImpl
