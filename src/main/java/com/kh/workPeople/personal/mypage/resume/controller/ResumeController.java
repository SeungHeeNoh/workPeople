package com.kh.workPeople.personal.mypage.resume.controller;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/personal/mypage")
public class ResumeController {

	private final ResumeService resumeService;
	private final HomeService homeService;

	@Autowired
	public ResumeController(ResumeService resumeService, HomeService homeService) {
		this.resumeService = resumeService;
		this.homeService = homeService;
	}

	@GetMapping("resumeManagement")
	public String resumeManagement(Model model, @AuthenticationPrincipal MemberImpl user) {

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
			model.addAttribute("resumeBrowseCount",resumeBrowseCount);
			model.addAttribute("applyCompanyCount",applyCompanyCount);
		}

		model.addAttribute("resumeList",resumeList);
		model.addAttribute("repExist",rep);
		model.addAttribute("repTitle",repTitle);

		return "personal/mypage/resumeManagement";
	}

	@GetMapping("resumeLookUp")
	public void resumeLookUp(){}

	@GetMapping("resumeEnroll")
	public String resumeEnroll(Model model, @AuthenticationPrincipal MemberImpl user){

		return "personal/mypage/resumeEnroll";
	}

	@GetMapping("resumeManagement/resumeEdit")
	public String resumeManagementResumeEdit(Model model){





		return "personal/mypage/resumeEdit";
	}

	@GetMapping("resumeManagement/resumeLookUp/{rNo}")
	public String resumeLookUp(@PathVariable int rNo, Model model){

		ResumeDetails resumeDetails = resumeService.resumeDetailsLookUp(rNo);
		ResumeDetails resumeDetailsFormat = resumeService.resumeDetailsLookUpFormat(rNo);

		resumeDetails.setBiBirthDateYearFormat(resumeDetailsFormat.getBiBirthDateYearFormat());
		resumeDetails.setBiAge(resumeDetailsFormat.getBiAge());
		resumeDetails.setBiAgeInFull(resumeDetailsFormat.getBiAgeInFull());
		resumeDetails.seteHighAdmissionFormat(resumeDetailsFormat.geteHighAdmissionFormat());
		resumeDetails.seteHighGraduationFormat(resumeDetailsFormat.geteHighGraduationFormat());
		resumeDetails.seteColleageAdmissionFormat(resumeDetailsFormat.geteColleageAdmissionFormat());
		resumeDetails.seteColleageGraduateFormat(resumeDetailsFormat.geteColleageGraduateFormat());
		resumeDetails.seteMasterAdmissionFormat(resumeDetailsFormat.geteMasterAdmissionFormat());
		resumeDetails.seteMasterGraduateFormat(resumeDetailsFormat.geteMasterGraduateFormat());
		resumeDetails.seteDoctorAdmissionFormat(resumeDetailsFormat.geteDoctorAdmissionFormat());
		resumeDetails.seteDoctorGraduateFormat(resumeDetailsFormat.geteDoctorGraduateFormat());

		model.addAttribute("resumeDetails",resumeDetails);

		return "personal/mypage/resumeLookUp";
	}

	@GetMapping("resumeManagement/resumeDelete/{rNo}")
	public String resumeManagementDelete(@PathVariable int rNo, Model model){

		int resumeIsApplyCompanyYN = homeService.resumeIsApplyCompanyYN(rNo);

		if(resumeIsApplyCompanyYN > 0){
			int resumeDelete = homeService.resumeDelete(rNo);
		} else{
			int basicInfoDeleteFromDB = homeService.basicInfoDeleteFromDB(rNo);
			int educationDeleteFromDB = homeService.educationDeleteFromDB(rNo);
			int careerDeleteFromDB = homeService.careerDeleteFromDB(rNo);
			int activityDeleteFromDB = homeService.activityDeleteFromDB(rNo);
			int licenseDeleteFromDB = homeService.licenseDeleteFromDB(rNo);
			int languageDeleteFromDB = homeService.languageDeleteFromDB(rNo);
			int awardsDeleteFromDB = homeService.awardsDeleteFromDB(rNo);
			int selfIntroductionDeleteFromDB = homeService.selfIntroductionDeleteFromDB(rNo);
			int resumeBrowseDeleteFromDB = homeService.resumeBrowseDeleteFromDB(rNo);
			int resumeDeleteFromDB = homeService.resumeDeleteFromDB(rNo);
		}


		return "redirect:/personal/mypage/resumeManagement";
	}




}
