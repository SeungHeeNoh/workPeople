package com.kh.workPeople.personal.mypage.scrap.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.scrap.model.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class ScrapController {

	private final ScrapService scrapService;
	private final HomeService homeService;

	@Autowired
	public ScrapController(ScrapService scrapService, HomeService homeService) {
		this.scrapService = scrapService;
		this.homeService=homeService;
	}

	@GetMapping("scrap")
	public String scrap(Model model, @AuthenticationPrincipal MemberImpl user) {

		List<JobVacancyLookUp> jobVacancyLookUpList = scrapService.jobVacancyLookUpList(user.getNo());

		for(JobVacancyLookUp job : jobVacancyLookUpList){
			int applyCompanyYN = homeService.applyCompanyYN(user.getNo(),job.getJvNo());

			if(applyCompanyYN > 0){
				job.setApplyYN(true);
			} else{
				job.setApplyYN(false);
			}
		}

		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

		Resume resume = homeService.selectResumeStatusY(user.getNo());
		model.addAttribute("resume",resume);

		return "personal/mypage/scrap";
	}
}
