package com.kh.workPeople.company.mypage.jvManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class jvManageController {
	
	@GetMapping("/jvManage")
	public String jvManage() {
		
		return "/company/mypage/jvManage";
	}
	
}
