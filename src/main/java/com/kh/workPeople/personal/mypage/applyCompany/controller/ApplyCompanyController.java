package com.kh.workPeople.personal.mypage.applyCompany.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class ApplyCompanyController {

	private final ApplyCompanyService applyCompanyService;

	@Autowired
	public ApplyCompanyController(ApplyCompanyService applyCompanyService) {
		this.applyCompanyService = applyCompanyService;
	}

	@GetMapping("applyCompany")
	public String applyCompany(Model model, @AuthenticationPrincipal MemberImpl user) {

		int applyCount = applyCompanyService.applyCount(user.getNo());
		int passCount = applyCompanyService.passCount(user.getNo());
		int interviewCount = applyCompanyService.interviewCount(user.getNo());
		int passAllCount = applyCompanyService.passAllCount(user.getNo());
		int failureCount = applyCompanyService.failureCount(user.getNo());

		model.addAttribute("applyCount",applyCount);
		model.addAttribute("passCount",passCount);
		model.addAttribute("interviewCount",interviewCount);
		model.addAttribute("passAllCount",passAllCount);
		model.addAttribute("failureCount",failureCount);

		List<JobVacancyLookUp> jobVacancyLookUpList = applyCompanyService.jobVacancyLookUpList(user.getNo());

//		for(JobVacancyLookUp jv : jobVacancyLookUpList){
//			Date beforeDate1 = jv.getAcDate();
//			Date beforeDate2 = jv.getRbDate();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
//			String afterDate1 = simpleDateFormat.format(beforeDate1);
//			String afterDate2 = simpleDateFormat.format(beforeDate2);
//			jv.setAcDateFormat(afterDate1);
//			jv.setRbDateFormat(afterDate2);
//		}

		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

		return "personal/mypage/applyCompany";
	}

	@PostMapping("applyCompany/applyCancel")
	public String applyCancel(){



		return "redirect:/personal/mypage/applyCompany";
	}



}
