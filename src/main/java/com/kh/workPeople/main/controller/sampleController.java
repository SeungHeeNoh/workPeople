package com.kh.workPeople.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sampleController {

	@GetMapping("/")
	public String login() {
		return "login/login";
	}
}
