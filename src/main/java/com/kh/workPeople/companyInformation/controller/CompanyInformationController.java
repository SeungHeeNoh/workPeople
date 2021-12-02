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
import com.kh.workPeople.companyInformation.model.vo.CompanyDetailInformation;

@Controller
@RequestMapping("/company-information")
public class CompanyInformationController {
	
	@Autowired
	private CompanyInformationService companyInformationService;

	@GetMapping("/detail-view")
	public ModelAndView detailView(@RequestParam(defaultValue="0") int no, Model model) {
		CompanyDetailInformation companyDetailInformation = companyInformationService.getCompanyDetailInformation(no);
		ModelAndView mv = new ModelAndView();
		
		if(companyDetailInformation != null) {
			mv.addObject("companyDetailInformation",companyDetailInformation);
			mv.addObject("newLineChar", "\n");
			mv.setViewName("company-information/detail-view");
		} else {
			mv.addObject("errorMessage", "기업 정보 상세 조회에 실패했습니다.");
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}
}
