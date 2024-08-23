package com.demo.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.entity.Users;
import com.demo.repository.UserRepo;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repository.findByUsername(username);
		
		if(user != null) {
			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
			              .password(user.getPassword())
			              .roles(user.getRole())
			              .build();
			return userDetails;
		}
		
		throw new UsernameNotFoundException("User not found : "+username);
	}
}
