package com.careerit.learnspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.learnspringboot.domain.Player;

@SpringBootApplication
public class SpringCoreBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Player player = new Player();
	}

}
