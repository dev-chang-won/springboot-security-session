package com.ch1.springbootsecuritysession.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ch1.springbootsecuritysession.model.UserSchema;

public interface UserRepository extends JpaRepository<UserSchema , Integer>{

	public UserSchema findByUsername(String username);
	
}