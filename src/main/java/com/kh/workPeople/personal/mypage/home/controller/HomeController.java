package com.kh.workPeople.personal.mypage.home.controller;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/personal/mypage")
public class HomeController {

	private final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("home")
	public String mypageHome(Model model, @AuthenticationPrincipal MemberImpl user) {

		int applyCount = homeService.applyCount(user.getNo());
		int resumeBrowseCount = homeService.resumeBrowseCount(user.getNo());
		int scrapCount = homeService.scrapCount(user.getNo());
		int interestedCompanyCount = homeService.interestedCompanyCount(user.getNo());
		int chatCount = homeService.chatCount(user.getNo());

		Resume resume = homeService.selectResumeStatusY(user.getNo());
		Date beforeDate = resume.getEnrollDate();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
		String afterDate = simpleDateFormat.format(beforeDate);


		model.addAttribute("applyCount",applyCount);
		model.addAttribute("resumeBrowseCount",resumeBrowseCount);
		model.addAttribute("scrapCount",scrapCount);
		model.addAttribute("interestedCompanyCount",interestedCompanyCount);
		model.addAttribute("chatCount",chatCount);

		model.addAttribute("resumeEnrollDate",afterDate);
		model.addAttribute("resume",resume);

		return "personal/mypage/home";
	} 






















}
	
