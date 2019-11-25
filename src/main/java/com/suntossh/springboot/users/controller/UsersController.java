package com.suntossh.springboot.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public ResponseEntity<String> status() {
		System.out.println("HB");
		System.out.println(env.getProperty("server.port"));
		return new ResponseEntity<String>(env.getProperty("server.port").toString(), HttpStatus.OK);
	}

}
