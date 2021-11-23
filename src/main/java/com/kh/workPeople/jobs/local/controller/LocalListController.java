package com.kh.workPeople.jobs.local.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs/local")
public class LocalListController {
	
	@GetMapping("/local-job-list")
	public String localList() {
		return "jobs/local/local-job-list";
	}
}