package com.kh.workPeople.company.mypage.memberInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class MemberInfoController {

	
	@GetMapping("/memberInfoPwd")
	public String memberPwd() {
		return "company/mypage/memberInfoPwd";
	}
	
	@GetMapping("/memberInfoUpdate")
	public String memberUpdate() {
		return "company/mypage/memberInfoUpdate";
	}
	
	@GetMapping("/memberleave")
	public String memberLeave() {
		return "company/mypage/memberleave";
	}
}
