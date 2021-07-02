package com.careerit.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.todo.model.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser,Long>{

}
