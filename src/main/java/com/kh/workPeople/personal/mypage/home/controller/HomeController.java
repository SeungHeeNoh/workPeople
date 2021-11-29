package com.kh.workPeople.personal.mypage.home.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

		model.addAttribute("applyCount",applyCount);
		model.addAttribute("resumeBrowseCount",resumeBrowseCount);
		model.addAttribute("scrapCount",scrapCount);
		model.addAttribute("interestedCompanyCount",interestedCompanyCount);
		model.addAttribute("chatCount",chatCount);


		Resume resume = homeService.selectResumeStatusY(user.getNo());
		String elName = null;

		if(resume != null) {
			Date beforeDate = resume.getEnrollDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
			String afterDate = simpleDateFormat.format(beforeDate);
			elName = resume.getS_name();
			model.addAttribute("resumeEnrollDate", afterDate);
			model.addAttribute("resume", resume);
		}

		List<JobVacancyLookUp> jobVacancyLookUpList = homeService.recommenedJobVacancyList(elName);

		for(JobVacancyLookUp job : jobVacancyLookUpList){
			int applyCompanyYN = homeService.applyCompanyYN(user.getNo(),job.getJvNo());

			if(applyCompanyYN > 0){
				job.setApplyYN(true);
			} else{
				job.setApplyYN(false);
			}
		}

		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

		return "personal/mypage/home";
	}

	@GetMapping("home/resumeEdit/{rNo}")
	public String resumeEdit(@PathVariable int rNo, Model model, @AuthenticationPrincipal MemberImpl user){




		return "personal/mypage/resumeEdit";
	}

	@GetMapping("home/resumeDelete/{rNo}")
	public String resumeDelete(@PathVariable int rNo, Model model, @AuthenticationPrincipal MemberImpl user){

		int resumeIsApplyCompanyYN = homeService.resumeIsApplyCompanyYN(rNo);

		if(resumeIsApplyCompanyYN > 0){
			int resumeDelete = homeService.resumeDelete(rNo);
		} else{
			int resumeDeleteFromDB = homeService.resumeDeleteFromDB(rNo);
		}

		return "redirect:/personal/mypage/home";
	}

	@GetMapping("home/applyResume/{rNo},{applyBtnNo}")
	public String applyResume(@PathVariable int rNo, @PathVariable int applyBtnNo, Model model, @AuthenticationPrincipal MemberImpl user){

//		int applyCompany = homeService.applyCompany(rNo,applyBtnNo);

		return "redirect:/personal/mypage/home";
	}




















}
	
