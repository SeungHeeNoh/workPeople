package com.kh.workPeople.company.mypage.companyInfo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.companyInfo.serivce.CompanyInfoService;

@Controller
@RequestMapping("/company/mypage")
public class CompanyInfoController {
	
	private CompanyInfoService companyInfoService;
	
	
	@Autowired
	public CompanyInfoController(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	@GetMapping("/companyInfoInsert")
	public String companyInfo(Member member) {
		
		companyInfoService.companyInfoSelect(member);
;		
		return "company/mypage/companyInfoInsert";
	}
	
	@PostMapping("/companyInfoInsert")
	public String companyInfoInsert() {
		return "company/mypage/companyInfoInsert";
	}
	

}
