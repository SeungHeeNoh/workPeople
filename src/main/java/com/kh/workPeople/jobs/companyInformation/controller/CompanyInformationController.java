package com.kh.workPeople.jobs.companyInformation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.jobs.common.JobsCommon;
import com.kh.workPeople.jobs.companyInformation.model.service.CompanyInformationService;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyData;

@Controller
@RequestMapping("/jobs/company-information")
public class CompanyInformationController {
	
	@Autowired
	private CompanyInformationService companyInformationService;
	@Autowired
	private JobsCommon jobsCommon;

	@GetMapping("/detail-view")
	public ModelAndView detailView(@RequestParam(defaultValue="0") int no, @AuthenticationPrincipal UserDetails user) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> queryMap = new HashMap<>();
		CompanyDetailInformation companyDetailInformation;
		
		queryMap.put("companyInformationNo", no);
		
		if(jobsCommon.isPersonalUser(user)) {
			queryMap.put("userNo", ((MemberImpl)user).getNo());
			
			mv.addObject("resumeList", companyInformationService.getResumeList(((MemberImpl)user).getNo()));
		}

		companyDetailInformation = companyInformationService.getCompanyDetailInformation(queryMap);		
		
		if(companyDetailInformation != null) {
			mv.addObject("companyDetailInformation",companyDetailInformation);
			mv.addObject("newLineChar", "\n");
			mv.setViewName("/jobs/company-information/detail-view");
		} else {
			mv.addObject("errorMessage", "잘못된 접근입니다.");
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}
	
	@PostMapping("/progressingJobVacancyData/{companyInformationNo}/{page}")
	@ResponseBody
	public JobVacancyData getProgressingJobVacancyData(@PathVariable int companyInformationNo, @PathVariable int page) {
		Map<String, Object> queryMap = new HashMap<>();
		
		queryMap.put("companyInformationNo", companyInformationNo);
		
		return companyInformationService.getProgressingJobVacancyData(queryMap, page);
	}
	
	@PostMapping("/expireJobVacancydData/{companyInformationNo}/{page}")
	@ResponseBody
	public JobVacancyData getExpireJobVacancydData(@PathVariable int companyInformationNo, @PathVariable int page) {
		Map<String, Object> queryMap = new HashMap<>();
		
		queryMap.put("companyInformationNo", companyInformationNo);
		
		return companyInformationService.getExpireJobVacancydData(queryMap, page);
	}
}
