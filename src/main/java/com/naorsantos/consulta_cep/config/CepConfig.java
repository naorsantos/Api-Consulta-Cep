package com.naorsantos.consulta_cep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.naorsantos.consulta_cep.repositories.CepRepositorie;
import com.naorsantos.consulta_cep.services.CepService;

@Configuration
public class CepConfig {

	@Bean
	CepService cepService(RestTemplate restTemplate, CepRepositorie cepRepositorie) {
		return new CepService(restTemplate, cepRepositorie);
		
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
}
