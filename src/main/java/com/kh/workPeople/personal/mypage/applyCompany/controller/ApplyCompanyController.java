package com.kh.workPeople.personal.mypage.applyCompany.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personal/mypage")
public class ApplyCompanyController {

	private final ApplyCompanyService applyCompanyService;

	@Autowired
	public ApplyCompanyController(ApplyCompanyService applyCompanyService) {
		this.applyCompanyService = applyCompanyService;
	}

	@GetMapping("applyCompany")
	public String applyCompany(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page ) {

		int applyCount = applyCompanyService.applyCount(user.getNo());
//		int passCount = applyCompanyService.passCount(user.getNo());
//		int interviewCount = applyCompanyService.interviewCount(user.getNo());
		int passAllCount = applyCompanyService.passAllCount(user.getNo());
		int failureCount = applyCompanyService.failureCount(user.getNo());

		model.addAttribute("applyCount",applyCount);
//		model.addAttribute("passCount",passCount);
//		model.addAttribute("interviewCount",interviewCount);
		model.addAttribute("passAllCount",passAllCount);
		model.addAttribute("failureCount",failureCount);


		Map<String, Object> applyCompanyMap = applyCompanyService.jobVacancyLookUpListPaging(user.getNo(),page);

		List<JobVacancyLookUp> jobVacancyLookUpList = (List<JobVacancyLookUp>)applyCompanyMap.get("jobVacancyLookUpList");
//		List<JobVacancyLookUp> jobVacancyLookUpList = applyCompanyService.jobVacancyLookUpList(user.getNo());

		for(JobVacancyLookUp job : jobVacancyLookUpList){
			JobVacancyLookUp job2 =applyCompanyService.applyCompanyRbDateFormat(job.getJvNo());
			if(job2 != null) {
				job.setRbDateFormat(job2.getRbDateFormat());
			}
		}


		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);
		model.addAttribute("pi",applyCompanyMap.get("pi"));

		return "personal/mypage/applyCompany";
	}

	@PostMapping("applyCompany/applyCancel")
	public String applyCancel(@RequestParam("jvNo") List<Integer> jvNoList, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request){

		int result = applyCompanyService.applyCancel(user.getNo(), jvNoList);

		if(result>0){
			rttr.addFlashAttribute("message","선택하신 이력서 열람기업 삭제에 성공했습니다.");
			return "redirect:/personal/mypage/applyCompany";
		}else{
			request.setAttribute("message","선택하신 이력서 열람기업 삭제에 실패했습니다.");
			return "/common/errorPage";
		}
	}




}
