package com.kh.workPeople.company.mypage.companyMain.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyMainMapper {

	Member memberInfoSelect(String userId);

	CompanyInformation companyInfoSelect(int userNo);

	JobVacancy jvInfoSelect(int ciNo);
	
	List<JobVacancy> findAllJvList();
	
	int registNewJvList(JobVacancy newJvList);
	
	

}
