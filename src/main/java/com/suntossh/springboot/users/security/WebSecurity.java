package com.suntossh.springboot.users.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();// Not 100% sure
		http.headers().frameOptions().disable();// enables h2 console to display
		http.authorizeRequests().antMatchers("/users/**").permitAll();// this will allow un authenticated following url
																		// patters to be allowed
	}

}
