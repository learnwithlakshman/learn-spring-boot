package com.careerit.todo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.todo.dto.UserDTO;
import com.careerit.todo.service.AppUserService;
import com.careerit.todo.service.exception.UserAlreadyExistsException;

@RestController
@RequestMapping("/api/user/")
public class AppUserController {

		private AppUserService appUserService;

		@Autowired
		public AppUserController(AppUserService appUserService) {
			this.appUserService = appUserService;
		}
		
		@PostMapping
		public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) throws UserAlreadyExistsException{
			System.out.println(userDTO);
			userDTO=appUserService.register(userDTO);
			return ResponseEntity.ok(userDTO);
		}
		
		

}
