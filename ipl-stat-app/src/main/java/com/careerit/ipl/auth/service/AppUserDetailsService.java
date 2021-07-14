package com.careerit.ipl.auth.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careerit.ipl.auth.domain.AppUser;
import com.careerit.ipl.auth.repo.AppUserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService  {

	@Autowired
	private AppUserRepo appUserRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public AppUser register(AppUser appUser) {
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		return this.appUserRepo.save(appUser);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			AppUser appUser = appUserRepo.findByUsername(username);
			if(appUser != null) {
				return new User(appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
			}
			throw new UsernameNotFoundException("User with name :"+username+" is not found");
	}

}
