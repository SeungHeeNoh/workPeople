package com.kh.workPeople.company.mypage.companyMain.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

public interface CompanyMainService {

	Member memberInfoselect(String userId);

	CompanyInformation companyInfoSelect(int userNo);

	JobVacancy jobVacancyInfoSelect(int ciNo);

	int jvIngCount(int no);

	

	

	
	

}
