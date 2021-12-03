package com.kh.workPeople.personal.mypage.report.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.report.model.service.ReportService;

@Controller
@RequestMapping("/personal/mypage/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@PostMapping("/job-vacancy/{jobVacancyNo}")
	@ResponseBody
	public Map<String, Object> insertReportVacancy(@PathVariable int jobVacancyNo, @AuthenticationPrincipal UserDetails user) {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Integer> queryMap = new HashMap<>();
		String message = "";
		
		queryMap.put("userNo", ((MemberImpl)user).getNo());
		queryMap.put("jobVacancyNo", jobVacancyNo);
		
		int result = reportService.insertReportVacancy(queryMap);
		
		if(result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		
		resultMap.put("message", message);
		
		return resultMap;
	}
}
