package com.kh.workPeople.account.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {

	@RequestMapping("/member/login")
	public String login() {
		return "account/login/login";
	}
	
	@RequestMapping("/manager/login")
	public String mangerLogin() {
		return "account/login/login-manager";
	}
	
	@GetMapping("member/change-password")
	public String changePassword() {
		return "account/join/change-password";
	}
}
