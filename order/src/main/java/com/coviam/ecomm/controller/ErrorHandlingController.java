package com.coviam.ecomm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Integer> internalServeException() {
		return new ResponseEntity<Integer>(1000, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}