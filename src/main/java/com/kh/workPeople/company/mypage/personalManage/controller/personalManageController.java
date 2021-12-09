package com.kh.workPeople.company.mypage.personalManage.controller;

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
import com.kh.workPeople.company.mypage.personalManage.model.service.personalManageService;

@Controller
@RequestMapping("/company/mypage")
public class personalManageController {
	
	private personalManageService personalManageService;
	
	@Autowired
	public personalManageController(personalManageService personalManageService) {
		this.personalManageService = personalManageService;
	}

	@GetMapping("/personalManage")
	public String personalManage(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		
		int cino = user.getCompanyNo();
		Map<String, Object> map = personalManageService.getJvList(page, cino);
		
		List<JobVacancy> jobVacancy = personalManageService.jobVacancyInfoSelect(cino);
		
		model.addAttribute("jobVacancy", jobVacancy);
		
		model.addAttribute("pi", map.get("pi"));
		model.addAttribute("jobVacancy", map.get("jobVacancy"));
		
		return "/company/mypage/personalManage";
	}
}
