package com.kh.workPeople.personal.mypage.resume.controller;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.UserImpl;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/personal/mypage")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;


	@GetMapping("resumeManagement")
	public String resumeManagement(Model model, @AuthenticationPrincipal UserImpl user) {

		List<Resume> resumeList = resumeService.resumeList(user.getNo());
		String rep = "N";
		String repTitle = "";
		int repResumeNo = 0;

		for(Resume resume : resumeList){
			Date beforeDate = resume.getEnrollDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
			String afterDate = simpleDateFormat.format(beforeDate);
			resume.setEnrollDateFormat(afterDate);

			if((resume.getStatusYN()).equals("Y")){
				rep = "Y";
				repTitle = resume.getTitle();
				repResumeNo = resume.getNo();
			}
		}

		if(repResumeNo != 0){
			int resumeBrowseCount = resumeService.resumeBrowseCount(repResumeNo);
			int applyCompanyCount = resumeService.applyCompanyCount(repResumeNo);
//			System.out.println(resumeBrowseCount);
			model.addAttribute("resumeBrowseCount",resumeBrowseCount);
			model.addAttribute("applyCompanyCount",applyCompanyCount);
		}


//		System.out.println(resumeList);
//		System.out.println(rep);
		model.addAttribute("resumeList",resumeList);
		model.addAttribute("repExist",rep);
		model.addAttribute("repTitle",repTitle);


		return "personal/mypage/resumeManagement";
	}






	@GetMapping("resumeLookUp")
	public void resumeLookUp(){}

	@GetMapping("resumeEnroll")
	public void resumeEnroll(){}
}
