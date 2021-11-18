package com.kh.workPeople.jobs.vacancyDetail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs/vacancyDetail")
public class VacancyDetailController {
	
	@GetMapping("/detail-view")
	public String vacancyDetail() {
		return "jobs/vacancy-detail/detail-view";
	}

}
