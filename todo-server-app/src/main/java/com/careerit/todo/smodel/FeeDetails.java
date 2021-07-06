package com.careerit.todo.smodel;

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
public class FeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "s_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "b_id")
	private BatchDetails batchDetails;
}
