package com.kh.workPeople.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class JobsController {

	@GetMapping("/vacancyDetail")
	public String vacancyDetail() {
		return "jobs/vacancyDetail/detailView";
	}
}
