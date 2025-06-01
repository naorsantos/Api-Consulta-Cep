package com.naorsantos.consulta_cep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naorsantos.consulta_cep.dto.CepResponse;
import com.naorsantos.consulta_cep.services.CepService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cep")
public class CepController {

	private CepService cepService;

	public CepController(CepService cepService) {
		this.cepService = cepService;
	}

	@GetMapping(value = "/{cep}")
	@Operation(summary = "Busca um cep pelo codigo de 8 digitos passado como parametro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Buscou o cep", 
				    content = { @Content(mediaType = "application/json", 
				      schema = @Schema(implementation = CepResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Cep passado invalido", 
		    content = @Content),
			@ApiResponse(responseCode = "404", description = "Cep não encontrado", 
		    content = @Content)			
	})
	public ResponseEntity<CepResponse> buscarCep(@PathVariable String cep) {
		if (cep == null || cep.isBlank() || cep.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		CepResponse cepResponse = cepService.buscarCep(cep);

		return ResponseEntity.ok().body(cepResponse);

	}

	@GetMapping(value = "/logadouro/{logadouro}")
	@Operation(summary = "Busca um cep pelo logadouro passado como parametro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Buscou o cep", 
				    content = { @Content(mediaType = "application/json", 
				      schema = @Schema(implementation = CepResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Logadouro passado invalido", 
		    content = @Content),
			@ApiResponse(responseCode = "404", description = "Cep não encontrado", 
		    content = @Content)			
	})
	public ResponseEntity<CepResponse> buscarPorLogadouro(@PathVariable String logadouro) {
		CepResponse buscarPorLogadouro = cepService.buscarPorLogadouro(logadouro);
		return ResponseEntity.ok().body(buscarPorLogadouro);

	}
}
