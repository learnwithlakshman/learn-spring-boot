package com.careerit.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.todo.dto.TodoDTO;
import com.careerit.todo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping("/{userid}")
	public TodoDTO addTodo(@PathVariable("userid") Long userid, @RequestBody TodoDTO todoDTO) {
		return todoService.addTodo(todoDTO, userid);
	}
	
	@DeleteMapping("/{userid}/{todoid}")
	public ResponseEntity<?> deleteTodo(@PathVariable("userid") Long userid,@PathVariable("todoid") Long todoid){
			boolean status = todoService.deleteTodo(userid,todoid);
			ResponseMessage responseMessage = new ResponseMessage();
			if(status) {
				responseMessage.setMessage("Todo is deleted");
				return ResponseEntity.ok(responseMessage);
			}else {
				responseMessage.setMessage("Todo was not able to deleted, reason would be no todo found with given id");
				return ResponseEntity.ok(responseMessage);
			}
			
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<List<TodoDTO>> getAllTodos(@PathVariable("userid") Long userid){
		   List<TodoDTO> list = todoService.getTodos(userid);
		   return ResponseEntity.ok(list);
	}

	@PutMapping("/{userid}")
	public TodoDTO updateTodo(@PathVariable("userid") Long userid, @RequestBody TodoDTO todoDTO) {
		return todoService.addTodo(todoDTO, userid);
	}
	

}
