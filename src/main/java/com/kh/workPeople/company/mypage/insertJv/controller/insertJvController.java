package com.kh.workPeople.company.mypage.insertJv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.insertJv.model.service.insertJvService;

@Controller
@RequestMapping("/company/mypage")
public class insertJvController {
	
	private insertJvService insertJvService;
	
	
	@Autowired
	public insertJvController(insertJvService insertJvService) {
		this.insertJvService = insertJvService;
	}
	
	@GetMapping("/insertJv")
	public String insertJv(@AuthenticationPrincipal MemberImpl user, Model model) {
		
		int cino = user.getCompanyNo();
		List<JobVacancy> jobVacancy = insertJvService.jobVacancyInfoSelect(cino);
		
		
		model.addAttribute("jobVacancy", jobVacancy);
		
		return "/company/mypage/insertJv";
	}
	
	@PostMapping("/insertJv")
	public String insertJobVacancy(@AuthenticationPrincipal MemberImpl user, CompanyInformation companyInfomation, JobVacancy jobVacancy, RedirectAttributes rttr
		) {
		
		int cino = user.getCompanyNo();
		
		String result;
		
		System.out.println("cino : " + cino);
		System.out.println("jobVacancy : " + jobVacancy);
		
		int result1 = insertJvService.insertInfo(jobVacancy, cino);
		
		System.out.println("result1 : " + result1);
		
		if(result1 > 0) {
			rttr.addFlashAttribute("message", "공고 등록이 완료되었습니다.");
			result = "redirect:/company/mypage/insertJv";
		} else {
			rttr.addFlashAttribute("errorMessage", "에러 발생");
			result = "redirect:/common/errorPage";
		}
		
		
		return "redirect:/company/mypage/insertJv";
	}

}
