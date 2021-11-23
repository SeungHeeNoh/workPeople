package com.kh.workPeople.personal.myPage.applyCompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class applyCompanyController {
	
	@GetMapping("applyCompany")
	public void applyCompany() {} 
}
