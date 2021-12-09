package com.kh.workPeople.manager.company.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.JobVacancyReportView;
import com.kh.workPeople.manager.company.model.service.CompanyReportService;

@Controller
@RequestMapping("/manager/company/report")
public class CompanyReportController {

	@Autowired
	private CompanyReportService service;

	  @GetMapping("/reportlist")
	  public ModelAndView reportList(ModelAndView mv, @RequestParam(defaultValue = "1") int page) { 
		Map<String, Object> map = service.getJvReportList(page);
		mv.addObject("getJvReportList", map.get("reportList"));
		mv.addObject("pi",map.get("pi"));
		
		List<JobVacancyReportView> list = service.getJvReportList(); 
		mv.addObject("list",list); 
		mv.setViewName("manager/company/reportlist");
		return mv; 
	}
	  
	  @GetMapping("/disable")
	  public ModelAndView disableJvList(ModelAndView mv, @RequestParam(value="reportCheck") String[] no, @RequestParam(defaultValue = "1") int page) {
		service.disableJobVacancy(no); 	// no = 비활성화 할려는 공고의 고유번호
		Map<String, Object> map = service.getJvReportList(page);
		mv.addObject("getJvReportList", map.get("reportList"));
		mv.addObject("pi",map.get("pi"));
		  
		List<JobVacancyReportView> list = service.getJvReportList();
		mv.addObject("list",list); 
		mv.setViewName("manager/company/reportlist");
		return mv; 
			  
	}

}
