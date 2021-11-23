package com.kh.workPeople.jobs.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs/job")
public class JobListController {
	
	@GetMapping("/big-job-list")
	public String jobList() {
		return "jobs/job/big-job-list";
	}
}