package com.kh.workPeople.personal.mypage.interestedCompany.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @PostMapping("/interestedCompany/list/delete")
    public String deleteInterestedComapnyList(@RequestParam("companyNo") List<Integer> companyNoList, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
    	int result = 0;
    	Map<String, Object> queryMap = new HashMap<>();
    	
    	queryMap.put("userNo", user.getNo());
    	queryMap.put("companyNoList", companyNoList);
    	
    	result = interestedCompanyService.deleteInterestedCompanyList(queryMap);
    	
    	if(result > 0) {
    		rttr.addFlashAttribute("message", "선택하신 관심 기업 목록 삭제에 성공했습니다.");
    		return "redirect:/personal/mypage/interestedCompany";	
    	} else {
    		request.setAttribute("errorMessage", "선택하신 관심 기업 목록 삭제에 실패했습니다.");
    		return "/common/errorPage/";
    	}
    }
    
    @PostMapping("/interestedCompany/company/{companyNo}")
    @ResponseBody
    public Map<String, Object> insertInterestedCompany(@PathVariable int companyNo, @AuthenticationPrincipal MemberImpl user) {
    	Map<String, Object> resultMap = new HashMap<>();
    	Map<String, Integer> queryMap = new HashMap<>();
    	String message = "";
    	
    	queryMap.put("userNo", user.getNo());
    	queryMap.put("companyNo", companyNo);
    	
    	int result = interestedCompanyService.insertInterestedCompany(queryMap);
    	
    	if(result > 0) {
    		message = "success";
    		resultMap.put("interestedCompanyCount", interestedCompanyService.getInterestedCompanyCount(companyNo));
    	}
    	
    	resultMap.put("message", message);

    	return resultMap;
    }
    
    @DeleteMapping("/interestedCompany/company/{companyNo}")
    @ResponseBody
    public Map<String, Object> deleteInterestedCompany(@PathVariable int companyNo, @AuthenticationPrincipal MemberImpl user) {
    	Map<String, Object> resultMap = new HashMap<>();
    	Map<String, Integer> queryMap = new HashMap<>();
    	String message = "";
    	
    	queryMap.put("userNo", user.getNo());
    	queryMap.put("companyNo", companyNo);
    	
    	int result = interestedCompanyService.deleteInterestedCompany(queryMap);
    	
    	if(result > 0) {
    		message = "success";
    		resultMap.put("interestedCompanyCount", interestedCompanyService.getInterestedCompanyCount(companyNo));
    	}
    	
    	resultMap.put("message", message);

    	return resultMap;
    }

}
