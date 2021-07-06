package com.careerit.todo.smodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private double fee;

	@ManyToOne
	@JoinColumn(name = "trainer_id", referencedColumnName = "id")
	private Trainer trainer;
	
	@ManyToMany(mappedBy = "batches")
	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany(mappedBy = "student")
	private List<FeeDetails> feeDetails = new ArrayList<FeeDetails>();
}
