package com.demo.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class MyBasicAuthEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void afterPropertiesSet() {
		setRealmName("sec-demo");
		super.afterPropertiesSet();
	
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
	response.setHeader("www.authenticate", "basic auth:"+getRealmName());
	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	PrintWriter out=response.getWriter();
	out.print("401- unauthorised, Event Management App ");
	}

}
