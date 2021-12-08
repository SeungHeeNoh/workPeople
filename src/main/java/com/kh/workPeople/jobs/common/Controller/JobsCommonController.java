package com.kh.workPeople.jobs.common.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.jobs.common.JobsCommon;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;

@Controller
@RequestMapping("/jobs/job-vacancy")
public class JobsCommonController {
	
	@Autowired
	private JobsCommon jobsCommon;
	@Autowired
	private ApplyCompanyService applyCompanyService;
	
	@PostMapping("/apply")
	public String applyCompany(@RequestParam int jvNo, @RequestParam int resumeNo, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
		String page = "/common/errorPage",
			   referer = (String)request.getHeader("REFERER")!=null? (String)request.getHeader("REFERER").split("http://localhost:8800/")[1] : "";
		
		if(referer.length() > 0) {
			int userNo = user.getNo();
			int applyCompany = applyCompanyService.applyCompany(userNo, jvNo);
			int appliedInsertCompany = applyCompanyService.insertNotStatusYAppliedTable(userNo, jvNo, resumeNo);
			
			if(applyCompany > 0 && appliedInsertCompany > 0) {
				page = "redirect:/" + referer;
				rttr.addFlashAttribute("message", "입사지원 되었습니다.");
			} else {
				request.setAttribute("errorMessage", "입사지원에 실패했습니다.");
			}
		} else {
			request.setAttribute("errorMessage", "잘못된 접근입니다.");
		}

		return page;
	}
	
	@PostMapping("/cancel-apply")
	public String cancelApplyCompany(@RequestParam int jvNo, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
		String page = "/common/errorPage",
			   referer = (String)request.getHeader("REFERER")!=null? (String)request.getHeader("REFERER").split("http://localhost:8800/")[1] : "";

		if(referer.length() > 0) {
			List<Integer> jvNoList = new ArrayList<>();
			jvNoList.add(jvNo);
			
			int result = applyCompanyService.applyCancel(user.getNo(), jvNoList);
			
			if(result > 0) {
				page = "redirect:/" + referer;
				rttr.addFlashAttribute("message", "입사지원이 취소 되었습니다.");
			} else {
				request.setAttribute("errorMessage", "입사지원 취소에 실패했습니다.");				
			}
		} else {
			request.setAttribute("errorMessage", "잘못된 접근입니다.");
		}

		return page;
	}
	
	@GetMapping("/resume-view")
	public String resumeView(@RequestParam int rNo, Model model) {
		Map<String, Object> resumeMap = jobsCommon.getResumeMap(rNo);
		
		model.addAllAttributes(resumeMap);
			
		return "jobs/common/resumeView";
	}

}
