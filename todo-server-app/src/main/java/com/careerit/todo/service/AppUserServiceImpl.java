package com.careerit.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.todo.dto.UserDTO;
import com.careerit.todo.model.AppUser;
import com.careerit.todo.repo.AppUserRepo;
import com.careerit.todo.service.exception.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppUserServiceImpl implements AppUserService {

	private AppUserRepo appUserRepo;

	@Autowired
	public AppUserServiceImpl(AppUserRepo appUserRepo) {
		this.appUserRepo = appUserRepo;
	}

	@Override
	public UserDTO register(UserDTO userDTO) throws UserAlreadyExistsException {
		Assert.notNull(userDTO, "User object can't be null empty");
		Assert.notNull(userDTO.getEmail(), "Email can't be empty or null");

		Optional<AppUser> optUser = appUserRepo.findByEmail(userDTO.getEmail());
		if (optUser.isPresent()) {
			throw new UserAlreadyExistsException();
		}

		AppUser appUser = UserDTO.toDomain(userDTO);
		appUser = appUserRepo.save(appUser);
		log.info("User registered with id :{}", appUser.getId());

		userDTO = UserDTO.toDTO(appUser);
		return userDTO;

	}

	@Override
	public UserDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(AppUser appUser) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deteleteUser(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
