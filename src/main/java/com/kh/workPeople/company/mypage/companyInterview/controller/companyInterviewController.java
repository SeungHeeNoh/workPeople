package com.kh.workPeople.company.mypage.companyInterview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class companyInterviewController {
	
	@GetMapping("/interview")
	public String interview() {
		
		return "/company/mypage/interview";
	}

}
