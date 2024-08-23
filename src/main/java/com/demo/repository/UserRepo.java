package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
	
	public Users findByUsername(String username);

}
