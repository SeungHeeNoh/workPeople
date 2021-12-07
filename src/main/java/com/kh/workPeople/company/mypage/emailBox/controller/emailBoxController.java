package com.kh.workPeople.company.mypage.emailBox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class emailBoxController {

	@GetMapping("/emailBox")
	public String emailBox() {
		
		return "/company/mypage/emailBox";
	}
	
}
