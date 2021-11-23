package com.kh.workPeople.personal.myPage.scrap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class scrapController {

	@GetMapping("scrap")
	public void scrap() {} 
}
