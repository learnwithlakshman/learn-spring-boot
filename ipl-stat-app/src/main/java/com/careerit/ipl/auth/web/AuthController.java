package com.careerit.ipl.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.ipl.auth.config.JwtTokenUtil;
import com.careerit.ipl.auth.domain.AppUser;
import com.careerit.ipl.auth.domain.JwtRequest;
import com.careerit.ipl.auth.domain.JwtResponse;
import com.careerit.ipl.auth.service.AppUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth/api")
@Slf4j
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtUtil;

	@Autowired
	private AppUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	

	@PostMapping("/login")
	public JwtResponse login(@RequestBody JwtRequest jwtRequest) {
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();
		return validateUserNamePassword(username, password);
	}

	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AppUser appUser) {
		appUser = userDetailsService.register(appUser);
		return ResponseEntity.ok("User is registered with id:"+appUser.getId());
	}

	private JwtResponse validateUserNamePassword(String username, String password) {

		try {
			UserDetails user = userDetailsService.loadUserByUsername(username);
			if (user != null) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				String token = jwtUtil.generateToken(user);
				JwtResponse jwtResponse = new JwtResponse();
				jwtResponse.setToken(token);
				return jwtResponse;
			}else {
				throw new UsernameNotFoundException("User not found with given username :"+username);
			}

		} catch (Exception e) {
			log.error("While logging in :{}",e);
			throw new BadCredentialsException("Please check user/password, bad credentials");
		}
		
	}
}
