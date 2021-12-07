package com.kh.workPeople.company.mypage.companyMain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.companyMain.model.service.CompanyMainService;

@Controller
@RequestMapping("/company/mypage")
public class CompanyMainController {
	
	private CompanyMainService companyMainService;
	
	@Autowired
	public CompanyMainController(CompanyMainService companyMainService) {
		this.companyMainService = companyMainService;
	}
	
	@GetMapping("/companyMain")
	public String companyMain(@AuthenticationPrincipal MemberImpl user, Model model) {
		// 메인페이지 공고 현황
		int jvIngCount = companyMainService.jvIngCount(user.getNo());
		
		model.addAttribute("jvIngCount", jvIngCount);
		
		// 메인페이지 공고 게시판
		String userId = user.getId();
		Member member = companyMainService.memberInfoselect(userId);
		
		int userNo = member.getNo();
		CompanyInformation companyInfo = companyMainService.companyInfoSelect(userNo);
		
		int ciNo = companyInfo.getNo();
		JobVacancy jobVacancy = companyMainService.jobVacancyInfoSelect(ciNo);
		
		model.addAttribute("member", member);
		model.addAttribute("companyInfo", companyInfo);
		model.addAttribute("jobVacancy", jobVacancy);
		
		
		return "company/mypage/companyMain";
	}
	
	

}
