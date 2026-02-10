package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.APIError;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final String EMAIL = "YOUR_CHITKARA_EMAIL";

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<APIError> badRequest(BadRequestException ex) {
		return ResponseEntity.badRequest().body(new APIError(false, EMAIL, ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIError> general(Exception ex) {
		return ResponseEntity.status(500).body(new APIError(false, EMAIL, "Internal Server Error"));
	}
}