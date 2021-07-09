package com.careerit.ipl.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careerit.ipl.domain.Player;

public interface PlayerRepo extends MongoRepository<Player, String> {

}
