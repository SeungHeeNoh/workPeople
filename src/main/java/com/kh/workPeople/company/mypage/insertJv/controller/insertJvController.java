package com.kh.workPeople.company.mypage.insertJv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class insertJvController {
	
	@GetMapping("/insertJv")
	public String insertJv() {
		
		return "/company/mypage/insertJv";
	}
	
	@PostMapping("/insert-jobvacancy")
	public String insertJobVacancy() {
		
		return "redirect:/main";
	}

}
