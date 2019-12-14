package com.suntossh.springboot.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.suntossh.springboot.users.shared.UsersDto;

public interface UsersService extends UserDetailsService{
	
	public UsersDto create(UsersDto users);

	public UsersDto loadUserByEmailId(String userEmail);

}
