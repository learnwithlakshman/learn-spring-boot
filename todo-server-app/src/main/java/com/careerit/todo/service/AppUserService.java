package com.careerit.todo.service;

import com.careerit.todo.dto.UserDTO;
import com.careerit.todo.model.AppUser;
import com.careerit.todo.service.exception.UserAlreadyExistsException;

public interface AppUserService {

	public UserDTO register(UserDTO userDTO) throws UserAlreadyExistsException;

	public UserDTO getUserByEmail(String email);

	public UserDTO updateUser(AppUser appUser) throws UserAlreadyExistsException;

	public boolean deteleteUser(Long id);
}
