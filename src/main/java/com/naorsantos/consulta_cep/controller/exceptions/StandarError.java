package com.naorsantos.consulta_cep.controller.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class StandarError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private HttpStatus status;
	private String error;
	private String message;

	public StandarError(Long timestamp, HttpStatus status, String error, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}