package com.kh.workPeople.company.mypage.companyInfo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.companyInfo.serivce.CompanyInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/company/mypage")
public class CompanyInfoController {
	
	private CompanyInfoService companyInfoService;
	
	
	@Autowired
	public CompanyInfoController(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	@GetMapping("/companyInfoInsert")
	public String companyInfo(Principal principal, Model model) {
		
		String userId = principal.getName();
		Member meber = companyInfoService.memberInfoSelect(userId);
		
		int userNo = meber.getNo();
		CompanyInformation companyInfo = companyInfoService.companyInfoSelect(userNo);
	
		model.addAttribute("meber", meber);
		model.addAttribute("companyInfo", companyInfo);

		return "company/mypage/companyInfoInsert";
	}
	
	@PostMapping("/companyInfoInsert")
	public String companyInfoInsert(Member member, CompanyInformation companyInformation, RedirectAttributes rttr, 
			@RequestParam("companyNO") int companyNO, @RequestParam("userNO") int userNO) {
		
		member.setNo(userNO);
		companyInformation.setNo(companyNO);
		
		int result = companyInfoService.info(member, companyInformation);
		
		if (result > 0) {
			rttr.addFlashAttribute("message", "기업 정보가 변경되었습니다.");
		}
		
		return "redirect:/company/mypage/companyInfoInsert";
	}
	

}
