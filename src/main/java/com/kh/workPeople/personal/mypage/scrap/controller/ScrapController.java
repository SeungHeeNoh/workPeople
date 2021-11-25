package com.kh.workPeople.personal.mypage.scrap.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.UserImpl;
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

	private ScrapService scrapService;

	@Autowired
	public ScrapController(ScrapService scrapService) {
		this.scrapService = scrapService;
	}

	@GetMapping("scrap")
	public String scrap(Model model, @AuthenticationPrincipal UserImpl user) {

		List<JobVacancyLookUp> jobVacancyLookUpList = scrapService.jobVacancyLookUpList(user.getNo());

		for(JobVacancyLookUp jv : jobVacancyLookUpList){
			Date beforeDate1 = jv.getAcDate();
			Date beforeDate2 = jv.getRbDate();
			Date beforeDate3 = jv.getJvPeriodEnd();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
			String afterDate1 = simpleDateFormat.format(beforeDate1);
			String afterDate2 = simpleDateFormat.format(beforeDate2);
			String afterDate3 = simpleDateFormat.format(beforeDate3);
			jv.setAcDateFormat(afterDate1);
			jv.setRbDateFormat(afterDate2);
			jv.setJvPeriodEndFormat(afterDate3);
		}

		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

		return "personal/mypage/scrap";
	}
}
