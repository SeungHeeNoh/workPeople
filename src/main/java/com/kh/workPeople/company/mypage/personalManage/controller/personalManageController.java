package com.kh.workPeople.company.mypage.personalManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class personalManageController {

	@GetMapping("/personalManage")
	public String personalManage() {
		
		return "/company/mypage/personalManage";
	}
}
