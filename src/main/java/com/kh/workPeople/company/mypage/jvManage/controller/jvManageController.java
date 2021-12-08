package com.kh.workPeople.company.mypage.jvManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.jvManage.model.service.jvManageService;

@Controller
@RequestMapping("/company/mypage")
public class jvManageController {
	
	private jvManageService jvManageService;
	
	@Autowired
	public jvManageController(jvManageService jvManageService) {
		this.jvManageService = jvManageService;
	}
	
	@GetMapping("/jvManage")
	public String jvManage(@AuthenticationPrincipal MemberImpl user, Model model) {
		
		int cino = user.getCompanyNo();
		List<JobVacancy> jobVacancy = jvManageService.jobVacancyInfoSelect(cino);
		
		model.addAttribute("jobVacancy", jobVacancy);
		
		return "/company/mypage/jvManage";
	}
	
}
