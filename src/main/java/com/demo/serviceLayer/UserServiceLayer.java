package com.demo.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.entity.Users;
import com.demo.repository.UserRepo;

@Service
public class UserServiceLayer {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	
	private PasswordEncoder passwordEncoder;
	
	
	public Users createUsers(Users users) {
		
		Users users2 = new Users();
		users2.setUsername(users.getUsername());
		users2.setPassword(passwordEncoder.encode(users.getPassword()));
		if(users.getUsername().equals("admin")) {
			users2.setRole("ADMIN");
		}
		else {
			users2.setRole("USER");
		
		}
		
		repo.save(users2);
		
		return users2;
	}

}
