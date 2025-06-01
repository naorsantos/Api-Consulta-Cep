package com.naorsantos.consulta_cep.util;

import java.time.LocalDateTime;

import com.naorsantos.consulta_cep.domain.Cep;
import com.naorsantos.consulta_cep.dto.CepResponse;

public class CepMapper {

	public static Cep cepResponseToCep(CepResponse cepResponse) {
		return new Cep(cepResponse.cep(), cepResponse.logradouro(), cepResponse.complemento(), cepResponse.unidade(),
				cepResponse.bairro(), cepResponse.localidade(), cepResponse.uf(), cepResponse.estado(),
				cepResponse.regiao(), cepResponse.ibge(), cepResponse.gia(), Integer.valueOf(cepResponse.ddd()), cepResponse.siafi(),
				LocalDateTime.now());

	}
}
