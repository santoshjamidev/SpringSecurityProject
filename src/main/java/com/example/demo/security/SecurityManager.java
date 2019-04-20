package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityManager extends WebSecurityConfigurerAdapter {

	@Autowired
	SampleFilterClass filterClass;
	
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/base/**").permitAll()
		.anyRequest().authenticated().and().httpBasic().disable()
		.addFilterAfter(filterClass, BasicAuthenticationFilter.class)
		.csrf().disable();
		
	}
}
