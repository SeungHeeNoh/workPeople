package com.kh.workPeople.jobs.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.kh.workPeople.common.vo.Activity;
import com.kh.workPeople.common.vo.Awards;
import com.kh.workPeople.common.vo.Career;
import com.kh.workPeople.common.vo.Language;
import com.kh.workPeople.common.vo.License;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.common.vo.SelfIntroduction;
import com.kh.workPeople.personal.mypage.resume.model.service.ResumeService;

@Component
public class JobsCommon {
	
	@Autowired
	private ResumeService resumeService;

	public boolean isPersonalUser(UserDetails user) {
		return (user != null && user instanceof MemberImpl && ((MemberImpl)user).getMemberType().getNo() == 1);
	}
	
	public Map<String, Object> getResumeMap(int rNo) {
		Map<String, Object> resumeMap = new HashMap<>();
		
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
		resumeMap.put("resumeDetails", resumeDetails);

		// 학력(고졸미만, 고졸, 검정고시, 대졸이상)에 따라 학력 출력하기위한 조건
		String resumeEtype = resumeDetails.geteType();
		String resumeColleageType = resumeDetails.geteColleageType();
		String resumeMasterName = resumeDetails.geteMasterName();
		String resumeDoctorName = resumeDetails.geteDoctorName();

		// 학력 출력시 필요한 조건 프론트로 넘기기
		resumeMap.put("resumeEtype", resumeEtype);
		resumeMap.put("resumeColleageType", resumeColleageType);
		resumeMap.put("resumeMasterName", resumeMasterName);
		resumeMap.put("resumeDoctorName", resumeDoctorName);
		

		// 경력 리스트 조회
		List<Career> resumeCareerList = resumeService.resumeCareerList(rNo);
		// 경력 리스트 프론트로 넘기기
		resumeMap.put("resumeCareerList", resumeCareerList);

		// 인턴, 대외활동 목록 조회
		List<Activity> resumeActivityList = resumeService.resumeActivityList(rNo);
		resumeMap.put("resumeActivityList", resumeActivityList);

		// 자격증/어학/수상내역 목록 조회
		List<License> resumeLicenseList = resumeService.resumeLicenseList(rNo);
		List<Language> resumeLanguageList = resumeService.resumeLanguageList(rNo);
		List<Awards> resumeAwardsList = resumeService.resumeAwardsList(rNo);
		resumeMap.put("resumeLicenseList", resumeLicenseList);
		resumeMap.put("resumeLanguageList", resumeLanguageList);
		resumeMap.put("resumeAwardsList", resumeAwardsList);

		// 자소서 항목 목록 조회
		List<SelfIntroduction> resumeSelfIntroductionList = resumeService.resumeSelfIntroductionList(rNo);
		resumeMap.put("resumeSelfIntroductionList", resumeSelfIntroductionList);
		
		return resumeMap;
	}
}
