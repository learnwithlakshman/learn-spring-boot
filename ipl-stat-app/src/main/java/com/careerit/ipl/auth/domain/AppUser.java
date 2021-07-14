package com.careerit.ipl.auth.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class AppUser {
	
		@Id
		private String id;
		private String username;
		private String password;
		private String email;
		
}
