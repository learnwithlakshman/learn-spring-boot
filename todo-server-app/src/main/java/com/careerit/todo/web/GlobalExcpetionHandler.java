package com.careerit.todo.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.careerit.todo.service.exception.TodoNotFoundException;
import com.careerit.todo.service.exception.UserAlreadyExistsException;
import com.careerit.todo.service.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExcpetionHandler  {

	@ExceptionHandler(value = { UserAlreadyExistsException.class,IllegalArgumentException.class })
	public ResponseEntity<?> handleConflict(Exception ex) {
		ErrorMessage obj = ErrorMessage.builder().message(ex.getMessage()).status(HttpStatus.CONFLICT)
				.time(LocalDateTime.now()).build();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(obj);
	}
	

	@ExceptionHandler(value = { UserNotFoundException.class,TodoNotFoundException.class })
	public ResponseEntity<?> resourceNotFound(Exception ex) {
		ErrorMessage obj = ErrorMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND)
				.time(LocalDateTime.now()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}
	

}
