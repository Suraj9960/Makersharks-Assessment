package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Users;
import com.demo.securityConfig.JwtUtil;
import com.demo.securityConfig.UserDetailsServiceImpl;
import com.demo.serviceLayer.UserServiceLayer;

@RestController
@RequestMapping("/api/public/")
public class AuthController {

	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserServiceLayer serviceLayer;
	
	
	
	
	@PostMapping("register")
	public ResponseEntity<Users>registerUser(@RequestBody Users users){
		
		Users newUsers =  serviceLayer.createUsers(users);
		
		return new ResponseEntity<Users>(newUsers,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users users) throws Exception{
		
		this.authenticate(users.getUsername() , users.getPassword());
		
		String username = users.getUsername();
		
		UserDetails userDetails =  userDetailsService.loadUserByUsername(username);
		
		String token =  jwtUtil.generateToken(userDetails.getUsername());
		
		return new ResponseEntity<String>("Token : { "+token+" } " ,HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			
			authenticationManager.authenticate(authenticationToken);
			
			
		}catch (BadCredentialsException e) {
			
			throw new BadCredentialsException("!! Invalid Username & Password , Please Enter correct one !! ");
		}
		
	}
	



}
