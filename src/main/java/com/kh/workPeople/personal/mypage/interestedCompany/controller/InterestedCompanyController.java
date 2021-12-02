package com.kh.workPeople.personal.mypage.interestedCompany.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.interestedCompany.model.service.InterestedCompanyService;

@Controller
@RequestMapping("/personal/mypage")
public class InterestedCompanyController {

    private final InterestedCompanyService interestedCompanyService;

    @Autowired
    public InterestedCompanyController(InterestedCompanyService interestedCompanyService) {
        this.interestedCompanyService = interestedCompanyService;
    }

    @GetMapping("interestedCompany")
    public String interestedCompany(Model model, @AuthenticationPrincipal MemberImpl user){

        List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = interestedCompanyService.jobVacancyLookUpSimpleList(user.getNo());

        for(JobVacancyLookUpSimple job : jobVacancyLookUpSimpleList){
            int jobVacancyCount = interestedCompanyService.jobVacancyCount(job.getNo());
            job.setCount(jobVacancyCount);
        }

        model.addAttribute("jobList",jobVacancyLookUpSimpleList);

        return "personal/mypage/interestedCompany";
    }
    
    @PostMapping("/interestedCompany/company/{companyNo}")
    @ResponseBody
    public Map<String, String> insertInterestedCompany(@PathVariable Integer companyNo, @AuthenticationPrincipal MemberImpl user) {
    	Map<String, String> resultMap = new HashMap<>();
    	Map<String, Integer> queryMap = new HashMap<>();
    	String message = "";
    	
    	queryMap.put("userNo", user.getNo());
    	queryMap.put("companyNo", companyNo);
    	
    	int result = interestedCompanyService.insertInterestedCompany(queryMap);
    	
    	if(result > 0) {
    		message = "success";
    	}
    	
    	resultMap.put("message", message);

    	return resultMap;
    }

}
