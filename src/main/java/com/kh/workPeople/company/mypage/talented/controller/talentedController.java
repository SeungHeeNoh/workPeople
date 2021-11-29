package com.kh.workPeople.company.mypage.talented.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.talented.service.TalentedService;

@Controller
@RequestMapping("/company/mypage")
public class talentedController {
	
	private TalentedService talentedService;
	
	@Autowired
	public talentedController(TalentedService talentedService) {
		this.talentedService = talentedService;
	}

	@GetMapping("/personInfoList")
	public String personInfoList(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		
		int userNo = user.getNo();
		
		Map<String, Object> map = talentedService.findList(page, userNo);
		
		
		
		
		
		return "company/mypage/personInfoList";
	}
	
	@GetMapping("/scrapPersonInfoList")
	public String scrapList() {
		return "company/mypage/scrapPersonInfoList";
	}

}
