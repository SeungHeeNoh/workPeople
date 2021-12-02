package com.kh.workPeople.companyInformation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.companyInformation.model.service.CompanyInformationService;

@Controller
@RequestMapping("/company-information")
public class CompanyInformationController {
	
	@Autowired
	private CompanyInformationService companyInformationService;

	@GetMapping("/detail-view")
	public ModelAndView detailView(@RequestParam(defaultValue="0") int no, Model model) {
		Map<String, Object> map = companyInformationService.getCompanyInformation(no);
		ModelAndView mv = new ModelAndView();
		
		if(map.get("member") != null && map.get("companyInformation") != null) {
			mv.addObject("member", map.get("member"));
			mv.addObject("companyInformation", map.get("companyInformation"));
			mv.addObject("newLineChar", "\n");
			mv.setViewName("company-information/detail-view");
		} else {
			mv.addObject("errorMessage", "기업 정보 상세 조회에 실패했습니다.");
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}
}
