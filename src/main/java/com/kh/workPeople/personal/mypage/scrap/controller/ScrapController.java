package com.kh.workPeople.personal.mypage.scrap.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.scrap.model.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personal/mypage")
public class ScrapController {

	private final ScrapService scrapService;
	private final HomeService homeService;
	private final ApplyCompanyService applyCompanyService;

	@Autowired
	public ScrapController(ScrapService scrapService, HomeService homeService, ApplyCompanyService applyCompanyService) {
		this.scrapService = scrapService;
		this.homeService=homeService;
		this.applyCompanyService = applyCompanyService;
	}

	@GetMapping("scrap")
	public String scrap(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page) {

//		Map<String, Object>

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
		if(resume != null){
			model.addAttribute("resume",resume);
			model.addAttribute("resumeNo",resume.getNo());
		}

		return "personal/mypage/scrap";
	}

	@GetMapping("scrap/applyResume/{rNo},{applyBtnNo}")
	public String applyResume(@PathVariable int rNo, @PathVariable int applyBtnNo, Model model, @AuthenticationPrincipal MemberImpl user){

		int applyCompany = applyCompanyService.applyCompany(rNo,applyBtnNo);

		return "redirect:/personal/mypage/scrap";
	}



}
