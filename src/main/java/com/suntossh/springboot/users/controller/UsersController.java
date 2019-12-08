package com.suntossh.springboot.users.controller;

import javax.validation.Valid;

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

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public ResponseEntity<String> status() {
		System.out.println("HB");
		System.out.println(env.getProperty("local.server.port"));
		return new ResponseEntity<String>(env.getProperty("spring.application.name")+" running on "+env.getProperty("local.server.port").toString(), HttpStatus.OK);
	}

	
	@PostMapping()
	public ResponseEntity<String> create(@Valid @RequestBody UserRequestModel userRequest){
		System.out.println(userRequest.toString());
		return new ResponseEntity<String>("Created user with ID ", HttpStatus.OK);
	}
	
}
