package com.careerit.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO {
	private Long id;
	private String title;
	private String description;
	private boolean status=true;
}
