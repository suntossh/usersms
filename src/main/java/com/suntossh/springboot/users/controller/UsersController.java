package com.suntossh.springboot.users.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suntossh.springboot.users.model.UserRequestModel;
import com.suntossh.springboot.users.model.UserResponseModel;
import com.suntossh.springboot.users.service.UsersService;
import com.suntossh.springboot.users.shared.UsersDto;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;

	@Autowired
	private UsersService usersSvcImpl;

	@GetMapping("/status/check")
	public ResponseEntity<String> status() {
		System.out.println("HB");
		System.out.println(env.getProperty("local.server.port"));
		return new ResponseEntity<String>(env.getProperty("spring.application.name") + " running on "
				+ env.getProperty("local.server.port").toString(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<UserResponseModel> create(@Valid @RequestBody UserRequestModel userRequest) {
		System.out.println(userRequest.toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UsersDto usersDto = mapper.map(userRequest, UsersDto.class);
		usersDto = usersSvcImpl.create(usersDto);
		UserResponseModel responseModel = mapper.map(usersDto, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}

}
