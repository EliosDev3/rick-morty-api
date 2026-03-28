package com.utict.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigWebClient {
	
	String url = "https://rickandmortyapi.com/api";
	
	@Bean
	WebClient webClient() {
		return WebClient.builder().baseUrl(url).build();
	}

}
