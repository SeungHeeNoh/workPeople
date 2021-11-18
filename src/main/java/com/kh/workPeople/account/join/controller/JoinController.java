package com.kh.workPeople.account.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/join")
public class JoinController {

	@GetMapping("/personal-join")
	public String personalJoin() {
		return "account/join/personal-join";
	}
	
	@GetMapping("/company-join")
	public String companyJoin() {
		return "account/join/company-join";
	}
}
