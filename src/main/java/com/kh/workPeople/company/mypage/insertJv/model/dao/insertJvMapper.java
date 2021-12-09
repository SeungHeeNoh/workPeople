package com.kh.workPeople.company.mypage.insertJv.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface insertJvMapper {

	
	int registNewJobVacancy(JobVacancy newJobVacancy);

	List<JobVacancy> jobVacancyInfoSelect(int cino);
	
}
