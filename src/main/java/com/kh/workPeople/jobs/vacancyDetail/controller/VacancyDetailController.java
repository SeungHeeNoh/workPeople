package com.kh.workPeople.jobs.vacancyDetail.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.jobs.common.JobsCommon;
import com.kh.workPeople.jobs.vacancyDetail.model.service.VacancyDetailService;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.latestPublication.model.service.LatestPublicationService;

@Controller
@RequestMapping("/jobs/vacancy-detail")
public class VacancyDetailController {	
	
	@Autowired
	private VacancyDetailService vacancyDetailService;
	@Autowired
	private LatestPublicationService latestPublicationService;
	@Autowired
	private ApplyCompanyService applyCompanyService;
	@Autowired
	private JobsCommon jobsCommon;
	
	
	@GetMapping("/detail-view")
	public ModelAndView vacancyDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam(defaultValue = "0") int no, @AuthenticationPrincipal UserDetails user) {
		String vCount = "";
		ModelAndView mv = new ModelAndView();
		Cookie[] cookies = request.getCookies();
		JobVacancyInformation jobVacancyInformation;
		Map<String, Object> queryMap = new HashMap<>();
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie c : cookies) {
				if(c.getName().equals("vCount")) {
					vCount = c.getValue();
				}
			}
		}
		
		if(vCount.indexOf("|" + no + "|") < 0) {
			Cookie newCookie = new Cookie("vCount", vCount + "|" + no + "|");
			response.addCookie(newCookie);
			
			vacancyDetailService.increaseCount(no);
		}
		
		queryMap.put("no", no);

		if(jobsCommon.isPersonalUser(user)) {
			queryMap.put("userNo", ((MemberImpl)user).getNo());
		}

		jobVacancyInformation = vacancyDetailService.selectJobVacancyInformation(queryMap);
		
		if(jobVacancyInformation != null) {
			if(jobsCommon.isPersonalUser(user)) {
				latestPublicationService.updateBrowse(queryMap);
				
				mv.addObject("resumeList", vacancyDetailService.getResumeList(((MemberImpl)user).getNo()));
			}

			mv.addObject("jobVacancyInformation", jobVacancyInformation);
			mv.setViewName("/jobs/vacancy-detail/detail-view");
		} else {
			mv.addObject("errorMessage", "공고 상세 조회에 실패했습니다.");
			mv.setViewName("/common/errorPage");
		}
		
		return mv;
	}
}
