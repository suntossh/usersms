package com.suntossh.springboot.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.suntossh.springboot.users.Entity.UsersEntity;
import com.suntossh.springboot.users.repository.UserRepository;
import com.suntossh.springboot.users.shared.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UsersDto create(UsersDto users) {
		users.setEncryptedPwd(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setUserid(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UsersEntity usersEntity = mapper.map(users, UsersEntity.class);
		usersEntity = userRepository.save(usersEntity);
		System.out.println("ID:"+usersEntity.getId());
		return mapper.map(usersEntity, UsersDto.class);
	}

}
