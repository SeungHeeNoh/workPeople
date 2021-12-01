package com.kh.workPeople.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.kh.workPeople.account.login.model.service.MemberLoginService;
import com.kh.workPeople.common.vo.Member;

@Component
public class MemberLoginFailureHandler implements AuthenticationFailureHandler {
	
	private final int MAX_FAILURE_COUNT = 5;
	private MemberLoginService memberLoginService;
	private String defaultUrl ="/account/member/login";
	
	@Autowired
	public MemberLoginFailureHandler(MemberLoginService memberLoginService) {
		this.memberLoginService = memberLoginService;
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
			Member member = memberLoginService.findMemberById(id);

			if(member != null) {
				if(member.getLoginFailCount() < MAX_FAILURE_COUNT) {
					memberLoginService.updateFailureCount(member.getId());
				} else {
					memberLoginService.updateAccountLock(member.getId());
					message = "6회 이상 시도로 계정이 잠겼습니다. 10분 후 재접속해주세요.";
				}
			}
		} else if(exception instanceof LockedException) {
			message = "6회 이상 시도로 계정이 잠겼습니다. 10분 후 재접속해주세요.";
		} else if(exception instanceof DisabledException) {
			message = "탈퇴한 회원입니다.";
		}
		
		request.setAttribute("id", id);
		request.setAttribute("loginRedirect", loginRedirect);
		request.setAttribute("message", message);
		
		request.getRequestDispatcher(defaultUrl).forward(request, response);
	}

}
