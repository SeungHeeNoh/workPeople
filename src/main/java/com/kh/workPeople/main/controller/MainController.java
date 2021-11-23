package com.kh.workPeople.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/main")
public class MainController {

	
	@GetMapping("/main")
	public String main() {
		return "main/main/main";
	}
	
	@PostMapping("/main")
	public String redirectmain() {
		return "redirect:/";
	}
}