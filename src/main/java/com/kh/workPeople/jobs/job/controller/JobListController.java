package com.kh.workPeople.jobs.job.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Sector;
import com.kh.workPeople.jobs.job.model.service.JobListService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/jobs/job")
public class JobListController {
	
	@Autowired
	private JobListService service;
	
	@GetMapping("/big-job-list")
	public ModelAndView jobList() {
		ModelAndView mv = new ModelAndView();
		List<Sector> sectorList = service.getSectorList();
		List<JobVacancyLookUp> jvList = service.getJobVacancyLookUpListBasic();
		mv.addObject("jvList", jvList);
		mv.addObject("sectorList",sectorList);
		mv.setViewName("jobs/job/big-job-list");
		
		return mv;
	}
	
	@GetMapping("/jobSearch")
	public ModelAndView jobSearch(Model model, @RequestParam(value="no") String[] no) {
		ModelAndView mv = new ModelAndView();
		log.info("no : {}", Arrays.toString(no));
		List<JobVacancyLookUp> jvList = service.getJobVacancyLookUpList(no);
		
		List<Sector> sectorList = service.getSectorList();
		
		mv.addObject("jvList", jvList);
		mv.addObject("sectorList",sectorList);
		
		mv.setViewName("jobs/job/big-job-list");
		
		return mv;
	}
	
	
}
