package com.careerit.todo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.todo.dto.TodoDTO;
import com.careerit.todo.model.AppUser;
import com.careerit.todo.model.Todo;
import com.careerit.todo.repo.AppUserRepo;
import com.careerit.todo.repo.TodoRepo;
import com.careerit.todo.service.exception.TodoNotFoundException;
import com.careerit.todo.service.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

	private AppUserRepo appUserRepo;
	private TodoRepo todoRepo;
	private ModelMapper modelMapper;

	@Autowired
	public TodoServiceImpl(AppUserRepo appUserRepo, TodoRepo todoRepo, ModelMapper modelMapper) {
		this.appUserRepo = appUserRepo;
		this.todoRepo = todoRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public TodoDTO addTodo(TodoDTO todoDTO, Long userid) {
		// Validation
		Optional<AppUser> opt = appUserRepo.findById(userid);
		AppUser user = opt.orElseThrow(() -> new UserNotFoundException("User with " + userid + " is not found"));
		Todo todo = modelMapper.map(todoDTO, Todo.class);
		todo.setUser(user);
		Todo savedTodo = todoRepo.save(todo);
		log.info("The User {} is added new Todo with id :{} and title {}", user.getName(), savedTodo.getId(),
				savedTodo.getTitle());
		todoDTO = modelMapper.map(savedTodo, TodoDTO.class);
		return todoDTO;
	}

	@Override
	public boolean deleteTodo(Long userid, Long todoid) {
		log.info("User {} trying delete todo {}",userid,todoid);
		validateUser(userid);
		Optional<Todo> optTodo = todoRepo.findById(todoid);
		Todo todo = optTodo.orElseThrow(() -> new TodoNotFoundException("Todo with " + todoid + " is not found"));
		todo.setStatus(false);
		log.info("Todo {} status changed",todo.isStatus());
		todoRepo.save(todo);
		return true;
	}

	private void validateUser(Long userid) {
		Optional<AppUser> opt = appUserRepo.findById(userid);
		opt.orElseThrow(() -> new UserNotFoundException("User with " + userid + " is not found"));
	}

	@Override
	public List<TodoDTO> getTodos(Long userid) {
		validateUser(userid);
		List<Todo> list = todoRepo.getTodos(userid);
		if(list.size() > 0) {
			return list.stream().map(t->modelMapper.map(t, TodoDTO.class)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	

}
