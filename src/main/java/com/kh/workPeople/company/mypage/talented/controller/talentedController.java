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
		
        // ????????? ??????????????? ?????? - (????????????,??????)
		ResumeDetails resumeDetails = resumeService.resumeDetailsLookUp(rNo);
		// ????????? ?????? ??????(????????????,????????? ??????->?????????,???????????? ??????, util.Date->string ??????(YYYY.MM)
		ResumeDetails resumeDetailsFormat = resumeService.resumeDetailsLookUpFormat(rNo);
		// ??????????????? ???????????? ????????? ?????? -> ??????????????? ????????? ??????
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

		// ???????????? ????????? ????????? ????????????/????????? ?????? ????????? ?????? ?????? front??? ?????????
		model.addAttribute("resumeDetails",resumeDetails);

		// ??????(????????????, ??????, ????????????, ????????????)??? ?????? ?????? ?????????????????? ??????
		String resumeEtype = resumeDetails.geteType();
		String resumeColleageType = resumeDetails.geteColleageType();
		String resumeMasterName = resumeDetails.geteMasterName();
		String resumeDoctorName = resumeDetails.geteDoctorName();

		// ?????? ????????? ????????? ?????? ???????????? ?????????
		model.addAttribute("resumeEtype",resumeEtype);
		model.addAttribute("resumeColleageType",resumeColleageType);
		model.addAttribute("resumeMasterName",resumeMasterName);
		model.addAttribute("resumeDoctorName",resumeDoctorName);

		// ?????? ????????? ??????
		List<Career> resumeCareerList = resumeService.resumeCareerList(rNo);
		// ?????? ????????? ???????????? ?????????
		model.addAttribute("resumeCareerList",resumeCareerList);

		// ??????, ???????????? ?????? ??????
		List<Activity> resumeActivityList = resumeService.resumeActivityList(rNo);
		model.addAttribute("resumeActivityList",resumeActivityList);

		// ?????????/??????/???????????? ?????? ??????
		List<License> resumeLicenseList = resumeService.resumeLicenseList(rNo);
		List<Language> resumeLanguageList = resumeService.resumeLanguageList(rNo);
		List<Awards> resumeAwardsList = resumeService.resumeAwardsList(rNo);
		model.addAttribute("resumeLicenseList",resumeLicenseList);
		model.addAttribute("resumeLanguageList",resumeLanguageList);
		model.addAttribute("resumeAwardsList",resumeAwardsList);

		// ????????? ?????? ?????? ??????
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
