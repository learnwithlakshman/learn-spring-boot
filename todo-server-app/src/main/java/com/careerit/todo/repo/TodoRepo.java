package com.careerit.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.todo.model.Todo;

public interface TodoRepo extends JpaRepository<Todo,Long> {

}
