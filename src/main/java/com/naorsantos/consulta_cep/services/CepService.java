package com.naorsantos.consulta_cep.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.naorsantos.consulta_cep.domain.Cep;
import com.naorsantos.consulta_cep.dto.CepResponse;
import com.naorsantos.consulta_cep.execptions.ObjectNotFoundException;
import com.naorsantos.consulta_cep.repositories.CepRepositorie;
import com.naorsantos.consulta_cep.util.CepMapper;

@Service
public class CepService {

	@Value("${default.busca.cep.url}")
	private String urlPadraoBuscaPorCep;

	@Value("${default.busca.logadouro.url}")
	private String urlPadraoBuscaPorLogadouro;

	private RestTemplate restTemplate;

	private CepRepositorie cepRepositorie;

	public CepService(RestTemplate restTemplate, CepRepositorie cepRepositorie) {
		this.restTemplate = restTemplate;
		this.cepRepositorie = cepRepositorie;
	}

	public CepResponse buscarCep(String cep) {

		CepResponse cepResponse;
		try {
			cepResponse = restTemplate.getForEntity(urlPadraoBuscaPorCep.concat(cep), CepResponse.class).getBody();
			salvarConsulta(cepResponse);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Nao foi possivel encontrar o cep passado");
		}
		
		return cepResponse;
				
	}

	public CepResponse buscarPorLogadouro(String logadouro) {
		CepResponse cepResponse;
	 try {
		 cepResponse = restTemplate.getForEntity(urlPadraoBuscaPorLogadouro.concat(logadouro), CepResponse.class).getBody();
	} catch (Exception e) {
		throw new ObjectNotFoundException("Nao foi possivel encontrar o cep passado");
	}
	return cepResponse;

	}

	public Cep salvarConsulta(CepResponse cepResponse) {
		Cep cep = CepMapper.cepResponseToCep(cepResponse);
		cepRepositorie.save(cep);
		return cep;
	}
}
