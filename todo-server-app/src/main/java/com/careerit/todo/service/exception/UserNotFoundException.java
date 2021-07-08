package com.careerit.todo.service.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5404743761260157213L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
