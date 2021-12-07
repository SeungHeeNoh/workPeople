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

import com.kh.workPeople.common.vo.Activity;
import com.kh.workPeople.common.vo.Awards;
import com.kh.workPeople.common.vo.Career;
import com.kh.workPeople.common.vo.Language;
import com.kh.workPeople.common.vo.License;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.common.vo.SelfIntroduction;
import com.kh.workPeople.jobs.vacancyDetail.model.service.VacancyDetailService;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.latestPublication.model.service.LatestPublicationService;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;

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
	private ResumeService resumeService;
	
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

		if(isPersonalUser(user)) {
			queryMap.put("userNo", ((MemberImpl)user).getNo());
		}

		jobVacancyInformation = vacancyDetailService.selectJobVacancyInformation(queryMap);
		
		if(jobVacancyInformation != null) {
			if(isPersonalUser(user)) {
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
	
	@PostMapping("/apply-company")
	public String applyCompany(@RequestParam int jvNo, @RequestParam int resumeNo, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
		String page = "redirect:/jobs/vacancy-detail/detail-view?no=" + jvNo;
		
		int userNo = user.getNo();
		
		int applyCompany = applyCompanyService.applyCompany(userNo, jvNo);
		int appliedInsertCompany = applyCompanyService.insertNotStatusYAppliedTable(userNo, jvNo, resumeNo);
		
		if(applyCompany > 0 && appliedInsertCompany > 0) {
			rttr.addFlashAttribute("message", "입사지원 되었습니다.");
		} else {
			request.setAttribute("errorMessage", "입사지원에 실패했습니다.");
			page = "/common/errorPage";
		}
		
		return page;
	}
	
	@PostMapping("/cancel-apply-company")
	public String cancelApplyCompany(@RequestParam int jvNo, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
		String page = "redirect:/jobs/vacancy-detail/detail-view?no=" + jvNo;
		List<Integer> jvNoList = new ArrayList<>();
		jvNoList.add(jvNo);
		
		int result = applyCompanyService.applyCancel(user.getNo(), jvNoList);
		
		if(result > 0) {
			rttr.addFlashAttribute("message", "입사지원이 취소 되었습니다.");
		} else {
			request.setAttribute("errorMessage", "입사지원 취소에 실패했습니다.");
			page = "/common/errorPage";
		}
		
		return page;
	}
	
	@GetMapping("/resume-view")
	public String resumeView(@RequestParam int rNo, Model model) {
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
			
		return "jobs/common/resumeView";
	}

	protected boolean isPersonalUser(UserDetails user) {
		return (user != null && user instanceof MemberImpl && ((MemberImpl)user).getMemberType().getNo() == 1);
	}
	
}
