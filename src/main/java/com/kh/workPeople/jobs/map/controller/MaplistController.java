package com.kh.workPeople.jobs.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs/map")
public class MaplistController {
	
	@GetMapping("/map-job-list")
	public String mapList() {

		return "jobs/map/map-job-list";
	}
}