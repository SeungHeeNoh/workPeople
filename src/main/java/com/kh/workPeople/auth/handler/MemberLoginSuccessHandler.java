package com.kh.workPeople.auth.handler;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.kh.workPeople.account.login.model.service.MemberLoginService;
import com.kh.workPeople.common.vo.MemberImpl;

@Component
public class MemberLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private MemberLoginService memberLoginService;
	private String defaultUrl = "/main";
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	public MemberLoginSuccessHandler(MemberLoginService memberLoginService) {
		this.memberLoginService = memberLoginService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String redirectUrl = "";
		MemberImpl userImpl= (MemberImpl)authentication.getPrincipal();
		
		if(userImpl.getIsLock().equals("Y")) {
			long now = Calendar.getInstance().getTimeInMillis();
					
			if(now < userImpl.getLastestTryLoginDate().getTime() + (1000 * 60 * 10)) {
				throw new LockedException("");
			}
		}
		
		memberLoginService.updateLoginInformation(userImpl);	
		clearAuthenticationAttributes(request);
		
		if(userImpl.getTempPwdYn().equals("Y")) {
			redirectUrl = "/account/member/change-password";
		} else {
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			
			if(savedRequest != null) {
				redirectUrl = savedRequest.getRedirectUrl();
			} else if(request.getParameter("loginRedirect").length() > 0) {
				redirectUrl = request.getParameter("loginRedirect");
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
