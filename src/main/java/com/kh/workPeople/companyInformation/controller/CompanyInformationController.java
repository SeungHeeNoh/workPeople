package com.kh.workPeople.companyInformation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.companyInformation.model.service.CompanyInformationService;

@Controller
@RequestMapping("/company-information")
public class CompanyInformationController {
	
	@Autowired
	private CompanyInformationService companyInformationService;

	@GetMapping("/detail-view")
	public String detailView(@RequestParam int no, Model model, RedirectAttributes rttr) {
		Map<String, Object> map = companyInformationService.getCompanyInformation(no);
		
		if(map.get("member") != null && map.get("companyInformation") != null) {
			model.addAttribute("member", map.get("member"));
			model.addAttribute("companyInformation", map.get("companyInformation"));
			model.addAttribute("newLineChar", "\n");
			return "company-information/detail-view"; 
		} else {
			rttr.addFlashAttribute("errorMessage", "잘못된 페이지 접근입니다.");
			return "redirect:/common/errorPage";
		}
	}
}
