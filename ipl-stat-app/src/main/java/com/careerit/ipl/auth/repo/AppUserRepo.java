package com.careerit.ipl.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careerit.ipl.auth.domain.AppUser;

public interface AppUserRepo extends MongoRepository<AppUser,String> {

	AppUser findByUsername(String username);

}
