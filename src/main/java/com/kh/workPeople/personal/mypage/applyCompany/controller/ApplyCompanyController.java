package com.kh.workPeople.personal.mypage.applyCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class ApplyCompanyController {
	
	@GetMapping("applyCompany")
	public void applyCompany() {} 
}
