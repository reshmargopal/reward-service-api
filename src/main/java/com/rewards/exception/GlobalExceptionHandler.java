package com.rewards.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handleGeneralException(Exception ex){
		return buildErrorResponse("An unexpected error occured.", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	private ResponseEntity<?> buildErrorResponse(String error, String message, HttpStatus status) {
		Map<String, Object> body = new HashMap<>();
		body.put("status", status.value());
		body.put("error", error);
		body.put("message", message);
		return new ResponseEntity<>(body,status);
	}
	
}
