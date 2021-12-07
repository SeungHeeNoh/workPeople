package com.kh.workPeople.company.mypage.companyMain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.companyMain.model.service.CompanyMainService;

@Controller
@RequestMapping("/company/mypage")
public class CompanyMainController {
	@Autowired
	private CompanyMainService companyMainService;
	
	@GetMapping("/companyMain")
	public String companyMain(@AuthenticationPrincipal MemberImpl user, Model model) {
		
		String userId = user.getId();
		Member member = companyMainService.memberInfoSelect(userId);
		
		int userNo = member.getNo();
		CompanyInformation companyInfo = companyMainService.companyInfoSelect(userNo);
		
		int ciNo = companyInfo.getNo();
		JobVacancy jv = companyMainService.jvInfoSelect(ciNo);
		
		model.addAttribute("member", member);
		model.addAttribute("companyIfo",companyInfo);
		model.addAttribute("jv",jv);
		
		return "company/mypage/companyMain";
	}

}
