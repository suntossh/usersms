package com.suntossh.springboot.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suntossh.springboot.users.model.UserLoginModel;
import com.suntossh.springboot.users.service.UsersService;
import com.suntossh.springboot.users.shared.UsersDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	Environment environment;

	@Autowired
	UsersService usersServiceImpl;

	public AuthenticationFilter(Environment environment, UsersService usersServiceImpl,
			AuthenticationManager authenticationManager) {
		this.environment = environment;
		this.usersServiceImpl = usersServiceImpl;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			UserLoginModel cred = new ObjectMapper().readValue(request.getInputStream(), UserLoginModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("Successfully Authenticated that User email is Valid.");

		User user = (User) authResult.getPrincipal();
		String userNameieEmail = user.getUsername();
		UsersDto usersDto = usersServiceImpl.loadUserByEmailId(userNameieEmail);
		String token = Jwts.builder().setSubject(usersDto.getUserid())
				.setExpiration(new Date(
						System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiry.time"))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret.key")).compact();
		response.addHeader("token", token);
		response.addHeader("userId", usersDto.getUserid());
	}
}
