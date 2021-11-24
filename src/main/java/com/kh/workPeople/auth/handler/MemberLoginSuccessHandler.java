package com.kh.workPeople.auth.handler;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.kh.workPeople.account.login.model.service.LoginService;
import com.kh.workPeople.common.vo.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private LoginService loginService;
	private String defaultUrl = "/main";
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public MemberLoginSuccessHandler(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String redirectUrl = "";
		UserImpl userImpl= (UserImpl)authentication.getPrincipal();
		
		if(userImpl.getIsLock().equals("Y")) {
			long now = Calendar.getInstance().getTimeInMillis();
					
			if(now < userImpl.getLastestTryLoginDate().getTime() + (1000 * 60 * 10)) {
				throw new LockedException("");
			}
		}
		
		loginService.updateLoginInformation(userImpl);	
		clearAuthenticationAttributes(request);
		
		if(userImpl.getTempPwdYn().equals("Y")) {
			redirectUrl = "/account/change-password";
		} else {
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			
			if(savedRequest != null) {
				redirectUrl = savedRequest.getRedirectUrl();
			} else {
				redirectUrl = defaultUrl;
			}
		}
		
		redirectStrategy.sendRedirect(request, response, redirectUrl);
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session == null) return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
