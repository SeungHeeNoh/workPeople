package com.kh.workPeople.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@GetMapping("/login")
	public String login() {
		return "account/login/login";
	}
	
	@GetMapping("/manager-login")
	public String mangerLogin() {
		return "account/login/login_manager";
	}
	
	@GetMapping("/join/personal-join")
	public String personalJoin() {
		return "account/join/personalJoin";
	}
	
	@GetMapping("/join/company-join")
	public String companyJoin() {
		return "account/join/companyJoin";
	}
}
