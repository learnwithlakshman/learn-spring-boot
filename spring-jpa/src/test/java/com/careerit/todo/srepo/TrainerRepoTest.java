package com.careerit.todo.srepo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.careerit.todo.smodel.Trainer;

@SpringBootTest
public class TrainerRepoTest {

		@Autowired
		private TrainerRepo trainerRepo;
		
		@Test
		public void trainerInfo() {
			List<Trainer> list = trainerRepo.findAll();
			
			list.stream().forEach(t->{
				System.out.println(t.getName()+" "+t.getEmail());
			});
			System.out.println("Total Trainer count :"+list.size());
			 
		}
}
