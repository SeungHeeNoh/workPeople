package com.kh.workPeople.company.mypage.insertJv.model.service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

public interface insertJvService {

	Member memberInfoselect(String userId);

	CompanyInformation companyInfoSelect(int userNo);

	JobVacancy jobVacancyInfoSelect(int ciNo);

	int insertInfo(JobVacancy jobVacancy);

}
