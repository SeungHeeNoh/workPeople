package com.kh.workPeople.company.mypage.writeMail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class writeMailController {
	
	@GetMapping("/writeMail")
	public String sednMail() {
		
		return "/company/mypage/writeMail";
	}
	
	

}
