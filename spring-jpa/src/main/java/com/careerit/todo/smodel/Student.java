package com.careerit.todo.smodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.engine.jdbc.batch.spi.Batch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String qualification;
	@OneToOne(mappedBy = "student")
	private Address address;
	
	@ManyToMany(targetEntity = BatchDetails.class)
	@JoinTable(name = "student_batch", joinColumns = @JoinColumn(name = "s_id"),inverseJoinColumns = @JoinColumn(name="b_id"))
	private List<Batch> batches = new ArrayList<Batch>();
	
	@OneToMany(mappedBy = "student")
	private List<FeeDetails> feeDetails = new ArrayList<FeeDetails>();
}
