package com.kh.workPeople.jobs.companyInformation.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyData;

@Mapper
public interface CompanyInformationMapper {

	CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap);
	
	int getJobVacancyListCount(Map<String, Object> queryMap);

	List<JobVacancyData> getJobVacancyDataList(Map<String, Object> queryMap);

	List<Resume> getResumeList(int userNo);
}
