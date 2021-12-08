package com.kh.workPeople.company.mypage.insertJv.controller;

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
import com.kh.workPeople.common.vo.Member;
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
		
		String userId = user.getId();
		Member member = insertJvService.memberInfoselect(userId);
		
		int userNo = member.getNo();
		CompanyInformation companyInfo = insertJvService.companyInfoSelect(userNo);
		
		int ciNo = companyInfo.getNo();
		JobVacancy jobVacancy = insertJvService.jobVacancyInfoSelect(ciNo);
		
		model.addAttribute("member", member);
		model.addAttribute("companyInfo", companyInfo);
		model.addAttribute("jobVacancy", jobVacancy);
		
		return "/company/mypage/insertJv";
	}
	
	@PostMapping("/insertJv")
	public String insertJobVacancy(CompanyInformation companyInfomation, JobVacancy jobVacancy, RedirectAttributes rttr,
			@RequestParam("ciNo") int ciNo) {
		
		companyInfomation.setNo(ciNo);
		
		String result;
		
		int result1 = insertJvService.insertInfo(jobVacancy);
		
		if(result1 > 0) {
			rttr.addFlashAttribute("message", "공고 등록이 완료되었습니다.");
			result = "redirect:/company/mypage/insertJv";
		} else {
			rttr.addFlashAttribute("errorMessage", "에러 발생");
			result = "redirect:/common/errorPage";
		}
		
		
		return result;
	}

}
