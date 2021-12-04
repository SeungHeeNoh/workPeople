package com.kh.workPeople.jobs.companyInformation.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;

@Mapper
public interface CompanyInformationMapper {

	CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap);

	List<JobVacancy> getJobVacancyList(Map<String, Object> queryMap);
}
