package com.kh.workPeople.jobs.companyInformation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.jobs.companyInformation.model.service.CompanyInformationService;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;

@Controller
@RequestMapping("/jobs/company-information")
public class CompanyInformationController {
	
	@Autowired
	private CompanyInformationService companyInformationService;

	@GetMapping("/detail-view")
	public ModelAndView detailView(@RequestParam(defaultValue="0") int no, @AuthenticationPrincipal UserDetails user) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> queryMap = new HashMap<>();
		CompanyDetailInformation companyDetailInformation;
		
		queryMap.put("companyInformationNo", no);
		
		if(user != null && user instanceof MemberImpl && ((MemberImpl)user).getMemberType().getNo() == 1) {
			queryMap.put("userNo", ((MemberImpl)user).getNo());
		}

		companyDetailInformation = companyInformationService.getCompanyDetailInformation(queryMap);		
		
		if(companyDetailInformation != null) {
			mv.addObject("companyDetailInformation",companyDetailInformation);
			mv.addObject("newLineChar", "\n");
			mv.setViewName("/jobs/company-information/detail-view");
		} else {
			mv.addObject("errorMessage", "기업 정보 상세 조회에 실패했습니다.");
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}
}
