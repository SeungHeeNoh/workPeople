package com.kh.workPeople.personal.mypage.resume.controller;

import com.kh.workPeople.common.vo.*;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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

//	이력서 상세페이지 조회 - 여기부터 복사 시작

		// 이력서 상세페이지 조회 - (기본정보,학력)
		ResumeDetails resumeDetails = resumeService.resumeDetailsLookUp(rNo);
		// 이력서 정보 조회(기본정보,학력의 나이->만나이,한국나이 포멧, util.Date->string 포멧(YYYY.MM)
		ResumeDetails resumeDetailsFormat = resumeService.resumeDetailsLookUpFormat(rNo);
		// 포멧팅해서 조회하고 불러온 객체 -> 상세페이지 객체에 할당
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

		// 포멧팅된 값까지 입력된 기본정보/학력의 모든 정보가 담긴 객체 front로 넘기기
		model.addAttribute("resumeDetails",resumeDetails);

		// 학력(고졸미만, 고졸, 검정고시, 대졸이상)에 따라 학력 출력하기위한 조건
		String resumeEtype = resumeDetails.geteType();
		String resumeColleageType = resumeDetails.geteColleageType();
		String resumeMasterName = resumeDetails.geteMasterName();
		String resumeDoctorName = resumeDetails.geteDoctorName();

		// 학력 출력시 필요한 조건 프론트로 넘기기
		model.addAttribute("resumeEtype",resumeEtype);
		model.addAttribute("resumeColleageType",resumeColleageType);
		model.addAttribute("resumeMasterName",resumeMasterName);
		model.addAttribute("resumeDoctorName",resumeDoctorName);

		// 경력 리스트 조회
		List<Career> resumeCareerList = resumeService.resumeCareerList(rNo);
		// 경력 리스트 프론트로 넘기기
		model.addAttribute("resumeCareerList",resumeCareerList);

		// 인턴, 대외활동 목록 조회
		List<Activity> resumeActivityList = resumeService.resumeActivityList(rNo);
		model.addAttribute("resumeActivityList",resumeActivityList);

		// 자격증/어학/수상내역 목록 조회
		List<License> resumeLicenseList = resumeService.resumeLicenseList(rNo);
		List<Language> resumeLanguageList = resumeService.resumeLanguageList(rNo);
		List<Awards> resumeAwardsList = resumeService.resumeAwardsList(rNo);
		model.addAttribute("resumeLicenseList",resumeLicenseList);
		model.addAttribute("resumeLanguageList",resumeLanguageList);
		model.addAttribute("resumeAwardsList",resumeAwardsList);

		// 자소서 항목 목록 조회
		List<SelfIntroduction> resumeSelfIntroductionList = resumeService.resumeSelfIntroductionList(rNo);
		model.addAttribute("resumeSelfIntroductionList",resumeSelfIntroductionList);

//	이력서 상세페이지 조회 - 여기까지 복사

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


	@PostMapping("changeStatusYResume")
	public String changeStatusYResume(HttpServletRequest request, @AuthenticationPrincipal MemberImpl user, @RequestParam("resumeNo") int resumeNo, RedirectAttributes rttr){

		List<Resume> resumeList = resumeService.resumeList(user.getNo());

		String str = "";

		for(Resume resume : resumeList){

			if((resume.getStatusYN()).equals("Y")){
				int result = resumeService.resumeStatusYtoN(resume.getNo());
				if(result<0){
					request.setAttribute("errorMessage", "대표이력서 변경에 실패했습니다.");
					str = "/common/errorPage";
				}
			}

			int result = resumeService.resumeStatusNtoY(resumeNo);

			if(result>0){
				rttr.addFlashAttribute("message", "대표이력서 변경에 성공했습니다.");
				str="redirect:/personal/mypage/resumeManagement";
			} else{
				request.setAttribute("errorMessage", "대표이력서 변경에 실패했습니다.");
				str = "/common/errorPage";
			}

		}

		return str;
	}


}
