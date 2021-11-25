package com.kh.workPeople.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class ManagerLoginFailureHandler implements AuthenticationFailureHandler {
	
	public ManagerLoginFailureHandler() {
		
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String id = request.getParameter("id");
		System.out.println(id);
	}
	

}
