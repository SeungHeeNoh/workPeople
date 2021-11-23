package com.kh.workPeople.company.mypage.talented;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class talentedComtroller {
	
	@GetMapping("/personInfoList")
	public String personInfoList() {
		return "company/mypage/personInfoList";
	}
	
	@GetMapping("/scrapPersonInfoList")
	public String scrapList() {
		return "company/mypage/scrapPersonInfoList";
	}

}
