package com.careerit.todo.service.exception;

import com.careerit.todo.util.AppConfigProperties;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserAlreadyExistsException() {
			this.message = AppConfigProperties.EMAIL_EXISTS_E_MESSAGE;
	}
	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserAlreadyExistsException [message=" + message + "]";
	}
	
}
