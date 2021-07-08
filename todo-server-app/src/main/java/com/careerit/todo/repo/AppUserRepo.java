package com.careerit.todo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.todo.model.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser,Long>{

			public Optional<AppUser> findByEmail(String email);
}
