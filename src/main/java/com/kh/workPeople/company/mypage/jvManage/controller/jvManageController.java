package com.kh.workPeople.company.mypage.jvManage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String jvManage(@AuthenticationPrincipal MemberImpl user,@RequestParam(defaultValue="1") int page, Model model) {
		
		int cino = user.getCompanyNo();
		Map<String, Object> map = jvManageService.getJvList(page, cino);
		
		List<JobVacancy> jobVacancy = jvManageService.jobVacancyInfoSelect(cino);
		
		List<JobVacancy> jobVacancy2 = jvManageService.jobVacancyInfoSelectEnd(cino);
		
		model.addAttribute("jobVacancy", jobVacancy);
		model.addAttribute("jobVacancy2", jobVacancy2);
		
		model.addAttribute("pi", map.get("pi"));
		model.addAttribute("jobVacancy", map.get("jobVacancy"));
		
		
		return "/company/mypage/jvManage";
	}
	
}
