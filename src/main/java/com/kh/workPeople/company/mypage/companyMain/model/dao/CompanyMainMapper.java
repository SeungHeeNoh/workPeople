package com.kh.workPeople.company.mypage.companyMain.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyMainMapper {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

	int jvIngCount(int cino);

	int jvEndCount(int cino);

	CompanyInformation companyInfoSelect(int cino);



	
	

}
