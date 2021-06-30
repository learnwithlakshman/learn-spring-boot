package com.careerit.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.learnspringboot.di.UserService;

@SpringBootApplication
public class SpringCoreBootApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			userService.downloadReport("Krish");
	}

}
