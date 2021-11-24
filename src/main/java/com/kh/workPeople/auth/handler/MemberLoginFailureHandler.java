package com.kh.workPeople.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.kh.workPeople.account.login.model.service.LoginService;

public class MemberLoginFailureHandler implements AuthenticationFailureHandler {
	
	private LoginService loginService;
	private String defaultUrl ="/account/login";
	
	public MemberLoginFailureHandler(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String id = request.getParameter("id");
		String loginRedirect = request.getParameter("loginRedirect");
		String message = "";
		
		if(exception instanceof AuthenticationServiceException) {
			message = "존재하지 않는 ID입니다.";
		} else if(exception instanceof BadCredentialsException) {
			message = "아이디 혹은 비밀번호가 맞지 않습니다.";
		} else if(exception instanceof LockedException) {
			message = "잠긴 계정입니다.";
		}
		
		request.setAttribute("id", id);
		request.setAttribute("loginRedirect", loginRedirect);
		request.setAttribute("message", message);
		
		request.getRequestDispatcher(defaultUrl).forward(request, response);
	}

}
