package com.kh.workPeople.company.mypage.companyMain.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

public interface CompanyMainService {


	List<JobVacancy> jobVacancyInfoSelect(int cino);

	int jvIngCount(int cino);

	int jvEndCount(int cino);

	

	

	
	

}
