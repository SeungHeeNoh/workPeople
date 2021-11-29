package com.kh.workPeople.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class errorpageController {
	
	@GetMapping("/errorPage")
	public String error() {
		return "common/errorPage";
	}

}
