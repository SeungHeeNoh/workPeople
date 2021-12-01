package com.kh.workPeople.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class ManagerLoginFailureHandler implements AuthenticationFailureHandler {
	
	private String defaultUrl ="/account/manager/login";
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String id = request.getParameter("id");
		String loginRedirect = request.getParameter("loginRedirect");
		String message = "";

		if(exception instanceof AuthenticationServiceException) {
			message = "존재하지 않는 ID입니다.";
		} else if(exception instanceof BadCredentialsException) {
			message = "아이디 혹은 비밀번호가 맞지 않습니다.";
		}
		
		FlashMap flashMap = new FlashMap();
		flashMap.put("message", message);
		flashMap.put("id", id);
		flashMap.put("loginRedirect", loginRedirect);
		
		FlashMapManager flashMapManager = new SessionFlashMapManager();
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		
		response.sendRedirect(defaultUrl);
	}
}
