package com.naorsantos.consulta_cep.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.naorsantos.consulta_cep.execptions.ObjectNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<StandarError> objecNotFound(ObjectNotFoundException exception) {

		StandarError error = new StandarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND, "Not found",
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}
