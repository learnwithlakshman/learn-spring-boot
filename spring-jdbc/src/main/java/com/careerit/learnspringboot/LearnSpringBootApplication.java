package com.careerit.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.careerit.learnspringboot.config.TenantGroupInformation;
import com.careerit.learnspringboot.dao.ContactDao;

@SpringBootApplication
public class LearnSpringBootApplication{
	
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private TenantGroupInformation tgi;
	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return (String... args)->{
			
			tgi.getTenantsByGroup("Group-2").stream().forEach(t->{
				System.out.println(t.getName()+" "+t.getEmail());
			});
		};
	}
	
}

