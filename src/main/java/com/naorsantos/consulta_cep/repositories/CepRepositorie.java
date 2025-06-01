package com.naorsantos.consulta_cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naorsantos.consulta_cep.domain.Cep;

public interface CepRepositorie extends JpaRepository<Cep, Integer>{

}
