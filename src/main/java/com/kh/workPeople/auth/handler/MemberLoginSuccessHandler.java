package com.kh.workPeople.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.workPeople.account.login.model.service.LoginService;
import com.kh.workPeople.common.vo.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private LoginService loginService;
	private String defaultUrl;

	public MemberLoginSuccessHandler(LoginService loginService) {
		this.loginService = loginService;
		this.defaultUrl = "/main";
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		UserImpl userImpl= (UserImpl)authentication.getPrincipal();
		
		loginService.updateLoginInformation(userImpl);
	}

}
