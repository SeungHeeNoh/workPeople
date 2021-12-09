package com.kh.workPeople.company.mypage.insertJv.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

public interface insertJvService {


	int insertInfo(JobVacancy jobVacancy);

	List<JobVacancy> jobVacancyInfoSelect(int cino);

}
