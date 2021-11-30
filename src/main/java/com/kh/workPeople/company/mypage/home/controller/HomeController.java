package com.kh.workPeople.company.mypage.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class HomeController {
	
	@GetMapping("home")
	public String companyMain() {
		
		return "company/mypage/companyMain";
		}

}
