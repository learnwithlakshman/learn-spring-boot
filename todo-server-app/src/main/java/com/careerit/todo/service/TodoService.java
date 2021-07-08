package com.careerit.todo.service;

import java.util.List;

import com.careerit.todo.dto.TodoDTO;

public interface TodoService {
	
		public TodoDTO addTodo(TodoDTO todoDTO,Long userid);

		public boolean deleteTodo(Long userid, Long todoid);
		public List<TodoDTO> getTodos(Long userid);
		
		

}	
