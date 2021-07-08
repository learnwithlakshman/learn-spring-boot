package com.careerit.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Todo {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
		private String title;
		private String description;
		private boolean status=true;
		
	
		@ManyToOne
		@JoinColumn(name = "user_id",referencedColumnName = "id")
		private AppUser user;
}
