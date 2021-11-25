package com.kh.workPeople.personal.mypage.home.controller;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.UserImpl;
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

	private HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("home")
	public String mypageHome(Model model, @AuthenticationPrincipal UserImpl user) {

		Resume resume = homeService.selectResumeStatusY(user.getNo());

		Date beforeDate = resume.getEnrollDate();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
		String afterDate = simpleDateFormat.format(beforeDate);
//		System.out.println("beforeDate : "+ beforeDate);
//		System.out.println("afterDate = "+afterDate);
//		System.out.println(resume);
		model.addAttribute("resumeEnrollDate",afterDate);
		model.addAttribute("resume",resume);

		return "personal/mypage/home";
	} 
	


















}
	
