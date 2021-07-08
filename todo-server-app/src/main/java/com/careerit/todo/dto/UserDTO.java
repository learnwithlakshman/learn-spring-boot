package com.careerit.todo.dto;

import com.careerit.todo.model.AppUser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;

	public static AppUser toDomain(UserDTO userDTO) {
		AppUser appUser = new AppUser();
		appUser.setId(userDTO.getId());
		appUser.setEmail(userDTO.email);
		appUser.setName(userDTO.name);
		appUser.setPassword(userDTO.password);
		return appUser;
	}

	public static UserDTO toDTO(AppUser appUser) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(appUser.getEmail());
		userDTO.setId(appUser.getId());
		userDTO.setName(appUser.getName());
		userDTO.setPassword(appUser.getPassword());
		return userDTO;
	}
}
