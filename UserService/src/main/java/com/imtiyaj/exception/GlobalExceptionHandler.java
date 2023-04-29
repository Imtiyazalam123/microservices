package com.imtiyaj.exception;

import com.imtiyaj.payload.ApiResponse;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotfoundException(ResourceNotFoundException ex) {
		
		String message = ex.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CallNotPermittedException.class)
	public ResponseEntity<String> handleCallNotPermittedExceptio(CallNotPermittedException ex) {
		return new ResponseEntity<>("Rating or hotel service is down : "+ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
	}
}
