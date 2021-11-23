package com.kh.workPeople.company.mypage.companyInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class CompanyInfoController {
	
	@GetMapping("/companyInfoInsert")
	public String companyInfo() {
		return "company/mypage/companyInfoInsert";
	}
	

}
