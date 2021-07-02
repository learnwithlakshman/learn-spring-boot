package com.careerit.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.todo.model.AppUser;
import com.careerit.todo.repo.AppUserRepo;

@SpringBootApplication
public class TodoSpringBootApplication implements CommandLineRunner {
		
		@Autowired
		private AppUserRepo userRepo;
	
		public static void main(String... args) {
			SpringApplication.run(TodoSpringBootApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
				AppUser appUser = new AppUser();
				appUser.setName("Krish");
				appUser.setEmail("krish.t@gmail.com");
				appUser.setPassword("krish@123");
				
				AppUser savedUser = userRepo.save(appUser);
				System.out.println("User is created with id :"+savedUser.getId());
		}
}
