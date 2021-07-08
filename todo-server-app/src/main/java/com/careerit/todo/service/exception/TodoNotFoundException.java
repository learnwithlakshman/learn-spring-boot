package com.careerit.todo.service.exception;

public class TodoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5404743761260157213L;

	public TodoNotFoundException(String message) {
		super(message);
	}
}
