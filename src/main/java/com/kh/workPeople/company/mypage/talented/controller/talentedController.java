package com.kh.workPeople.company.mypage.talented.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.common.vo.Activity;
import com.kh.workPeople.common.vo.Awards;
import com.kh.workPeople.common.vo.Career;
import com.kh.workPeople.common.vo.Language;
import com.kh.workPeople.common.vo.License;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.common.vo.SelfIntroduction;
import com.kh.workPeople.company.mypage.talented.service.TalentedService;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;

@Controller
@RequestMapping("/company/mypage")
public class talentedController {
	
	private TalentedService talentedService;
	private final ResumeService resumeService;
	
	@Autowired
	public talentedController(TalentedService talentedService, ResumeService resumeService) {
		this.talentedService = talentedService;
		this.resumeService = resumeService;
	}

	@GetMapping("/personInfoList")
	public String personInfoList(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		
		int userNo = user.getNo();
		
		Map<String, Object> map = talentedService.findList(page, userNo);
		
		model.addAttribute("personList", map.get("personList"));
		model.addAttribute("pi", map.get("pi"));
		model.addAttribute("cino", map.get("cino"));
		model.addAttribute("listCount", map.get("listCount"));
		
		
		return "company/mypage/personInfoList";
	}
	

	@GetMapping("/scrapPersonInfoList")
	public String scrapList(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		

		int userNo = user.getNo();
		
		Map<String, Object> map = talentedService.findScrapList(page, userNo);
		
		model.addAttribute("personList", map.get("personList"));
		model.addAttribute("pi", map.get("pi"));
		model.addAttribute("cino", map.get("cino"));
		model.addAttribute("listCount", map.get("scrapListCount"));
		
		
		return "company/mypage/scrapPersonInfoList";
	}
	
	@GetMapping("/personDetailView")
	public String detailView(@RequestParam("rno") int rNo, @RequestParam("cino") int cino, Model model) {
		
		int check = talentedService.selectResumeCount(rNo, cino);
		
		if (check == 0) {
			int result = talentedService.insertResume(rNo, cino);
		}
		
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
		
		return "company/mypage/personDetailView";
	}
	
	
	

    
    @PostMapping("/scrap")
	@ResponseBody
	public int scrap(@RequestBody Map<String, Object> map, @AuthenticationPrincipal MemberImpl user) throws ParseException{
		
		int mno = user.getNo();
		
		int rno = Integer.parseInt(String.valueOf(map.get("rno")));
		
		int result = talentedService.insertscrap(mno, rno);
		
		return result;
	}
    
    @PostMapping("/nonescrap")
   	@ResponseBody
   	public int nonescrap(@RequestBody Map<String, Object> map, @AuthenticationPrincipal MemberImpl user) throws ParseException{
   		
   		int mno = user.getNo();
   		
   		int rno = Integer.parseInt(String.valueOf(map.get("rno")));
   		
   		int result = talentedService.deletescrap(mno, rno);
   		
   		return result;
   	}
	
	
	
	
	
	
	

}
