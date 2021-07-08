package com.careerit.todo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
		
		@Column(unique = true)
		private String email;
		
		private String password;
		
		@Enumerated(EnumType.STRING)
		private Status status=Status.ACTIVE;
		
		@OneToMany(mappedBy = "user")
		private List<Todo> todos=new ArrayList<Todo>();
		
		public void addTodo(Todo todo) {
			this.todos.add(todo);
		}
		public void removeTodo(Todo todo) {
			this.todos.remove(todo);
		}

}
