package com.suntossh.springboot.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsersmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersmsApplication.class, args);
	}

}
