package com.kh.workPeople.jobs.vacancyDetail.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.jobs.vacancyDetail.model.service.VacancyDetailService;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@Controller
@RequestMapping("/jobs/vacancyDetail")
public class VacancyDetailController {	
	
	@Autowired
	private VacancyDetailService vacancyDetailService;
	
	@GetMapping("/detail-view")
	public ModelAndView vacancyDetail(HttpServletRequest request, @RequestParam(defaultValue = "0") int no, @AuthenticationPrincipal UserDetails user) {
		Cookie[] cookies = request.getCookies();
		ModelAndView mv = new ModelAndView();
		JobVacancyInformation jobVacancyInformation;
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("no", no);

		if(user != null && user instanceof MemberImpl && ((MemberImpl)user).getMemberType().getNo() == 1) {	
			queryMap.put("userNo", ((MemberImpl)user).getNo());
		}

		jobVacancyInformation = vacancyDetailService.selectJobVacancyInformation(queryMap);
		
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
