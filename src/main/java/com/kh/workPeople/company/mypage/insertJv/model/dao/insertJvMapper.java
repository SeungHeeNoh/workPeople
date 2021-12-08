package com.kh.workPeople.company.mypage.insertJv.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface insertJvMapper {

	Member memberInfoselect(String userId);

	CompanyInformation companyInfoSelect(int userNo);

	JobVacancy jobVacancyInfoSelect(int ciNo);
	
	int registNewJobVacancy(JobVacancy newJobVacancy);
	
}
