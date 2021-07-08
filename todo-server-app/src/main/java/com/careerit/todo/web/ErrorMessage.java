package com.careerit.todo.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessage {

		private String message;
		private HttpStatus status;
		private LocalDateTime time;
}
