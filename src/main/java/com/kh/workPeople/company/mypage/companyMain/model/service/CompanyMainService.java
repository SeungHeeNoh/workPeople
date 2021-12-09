package com.kh.workPeople.company.mypage.companyMain.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

public interface CompanyMainService {



	int jvIngCount(int cino);

	int jvEndCount(int cino);

	CompanyInformation companyInfoSelect(int cino);

	Map<String, Object> getJvList(int page, int cino);

	

	

	
	

}
