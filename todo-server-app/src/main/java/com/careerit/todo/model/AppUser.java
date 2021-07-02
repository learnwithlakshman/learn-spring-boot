package com.careerit.todo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AppUser {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
		private String name;
		private String email;
		private String password;
		
		@OneToMany(mappedBy = "user")
		private List<Todo> todos=new ArrayList<Todo>();
		
		public void addTodo(Todo todo) {
			this.todos.add(todo);
		}
		public void removeTodo(Todo todo) {
			this.todos.remove(todo);
		}

}
