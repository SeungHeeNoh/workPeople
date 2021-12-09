package com.kh.workPeople.company.mypage.companyMain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
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
	public String companyMain(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		Map<String, Object> map = companyMainService.getJvList(page);
		
		
		
		// 메인페이지 공고 게시판
		int cino = user.getCompanyNo();
		List<JobVacancy> jobVacancy = companyMainService.jobVacancyInfoSelect(cino);
		
		// 기업 로고
		CompanyInformation companyInfo = companyMainService.companyInfoSelect(cino);
		
		// 메인페이지 공고 현황
		// 진행중 공고 수
		int jvIngCount = companyMainService.jvIngCount(cino);
		// 마감된 공고 수
		int jvEndCount = companyMainService.jvEndCount(cino);
		
		model.addAttribute("jvIngCount", jvIngCount);
		model.addAttribute("jvEndCount", jvEndCount);
		model.addAttribute("jobVacancy", jobVacancy);
		model.addAttribute("companyInfo", companyInfo);
		
		return "company/mypage/companyMain";
	}
	
	

}
