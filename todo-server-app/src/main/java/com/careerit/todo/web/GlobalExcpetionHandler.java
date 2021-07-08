package com.careerit.todo.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.careerit.todo.service.exception.UserAlreadyExistsException;

@RestControllerAdvice
public class GlobalExcpetionHandler  {

	@ExceptionHandler(value = { UserAlreadyExistsException.class,IllegalArgumentException.class })
	public ResponseEntity<?> handleConflict(Exception ex) {
		System.out.println("Exception handler....");
		ErrorMessage obj = ErrorMessage.builder().message(ex.getMessage()).status(HttpStatus.CONFLICT)
				.time(LocalDateTime.now()).build();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(obj);
	}
	


}
