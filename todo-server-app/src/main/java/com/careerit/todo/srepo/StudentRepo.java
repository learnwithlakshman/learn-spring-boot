package com.careerit.todo.srepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.todo.smodel.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
