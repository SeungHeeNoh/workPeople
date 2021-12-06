package com.kh.workPeople.account.changePassword.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.workPeople.account.changePassword.model.service.ChangePasswordService;
import com.kh.workPeople.common.vo.MemberImpl;

@Controller
@RequestMapping("/account/member")
public class changePasswordController {
	
	@Autowired
	private ChangePasswordService changePasswordService;

	@GetMapping("/change-password")
	public String changePassword(@AuthenticationPrincipal MemberImpl memberImpl, HttpServletRequest request) {
		String page = "account/change-password/change-password";
		
		if(!memberImpl.getTempPwdYn().equals("Y")) {
			request.setAttribute("errorMessage", "잘못된 접근입니다.");
			page = "/common/errorPage";
		}
		
		return page;
	}
	
	@PostMapping("/change-password")
	public String updatePassword(@AuthenticationPrincipal MemberImpl memberImpl, String password, HttpServletRequest request) {
		String page = "account/change-password/change-password";
		int result = changePasswordService.changePassword(memberImpl, password);
		
		if(result <= 0) {
			request.setAttribute("errorMessage", "비밀번호 변경에 실패하였습니다.");
			page = "/common/errorPage";
		}
		
		return page;
	}
	
}
