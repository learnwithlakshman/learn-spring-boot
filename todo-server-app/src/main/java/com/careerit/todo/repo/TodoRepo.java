package com.careerit.todo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.todo.model.Todo;

public interface TodoRepo extends JpaRepository<Todo,Long> {

		@Query(value = "select * from todo t where t.user_id=:id and t.status='t'",nativeQuery = true)
		List<Todo> getTodos(@Param("id") Long userid);	
	
		Page<Todo> findByUserId(Long userid, Pageable pageable );	
		
		
}
