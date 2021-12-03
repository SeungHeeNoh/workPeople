package com.kh.workPeople.jobs.local.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.jobs.local.service.LocalListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jobs/local")
public class LocalListController {
	
	
	@Autowired
	private LocalListService service;
	
	@GetMapping("/local-job-list")
	public ModelAndView localList() {
		ModelAndView mv = new ModelAndView();
		List<JobVacancyLookUp> lcList = service.getLocalVacancyLookUpListBasic();
		
		mv.addObject("lcList", lcList);
		mv.setViewName("jobs/local/local-job-list");
		return mv;
	}
	
	@GetMapping("/localSearch")
	public ModelAndView localSearch(Model model,@RequestParam(value="local") String[] local) {
		ModelAndView mv = new ModelAndView();
		// log.info("local : {}", Arrays.toString(local));
		List<JobVacancyLookUp> lcList = service.getLocalVacancyLookUpList(local);
		// log.info("lcList : {}", lcList);
		mv.addObject("lcList", lcList);
		mv.setViewName("jobs/local/local-job-list");
		return mv;
	}
	
	
}