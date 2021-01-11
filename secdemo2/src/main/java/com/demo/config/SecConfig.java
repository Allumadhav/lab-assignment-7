package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class SecConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyBasicAuthEntryPoint myBasicAuthEntryPoint;

	@Autowired
	private DetailService detailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailService);
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password("admin123").roles("ADMIN") .and()
		 * .withUser("emp").password("emp123").roles("EMP");
		 */
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		//
		.antMatchers("/emp/**").hasAnyRole("ADMIN","EMP")
		//
		.antMatchers("/home/**").permitAll()
		.and().httpBasic().authenticationEntryPoint(myBasicAuthEntryPoint)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

}
