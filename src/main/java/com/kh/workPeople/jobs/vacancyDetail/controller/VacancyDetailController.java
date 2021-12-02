package com.kh.workPeople.jobs.vacancyDetail.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.jobs.vacancyDetail.model.service.VacancyDetailService;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@Controller
@RequestMapping("/jobs/vacancyDetail")
public class VacancyDetailController {	
	
	@Autowired
	private VacancyDetailService vacancyDetailService;
	
	@GetMapping("/detail-view")
	public ModelAndView vacancyDetail(@RequestParam(defaultValue = "0") int no, HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
		JobVacancyInformation jobVacancyInformation = vacancyDetailService.selectJobVacancyInformation(no);
		ModelAndView mv = new ModelAndView();
		
		if(jobVacancyInformation != null) {
			mv.addObject("jobVacancyInformation", jobVacancyInformation);
			mv.setViewName("/jobs/vacancy-detail/detail-view");
		} else {
			mv.addObject("errorMessage", "공고 상세 조회에 실패했습니다.");
			mv.setViewName("/common/errorPage");
		}
		
		return mv;
	}

}
