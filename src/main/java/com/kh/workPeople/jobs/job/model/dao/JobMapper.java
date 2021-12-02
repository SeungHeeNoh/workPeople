package com.kh.workPeople.jobs.job.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Sector;

@Mapper
public interface JobMapper {
	List<Sector> getSectorList();

	List<CompanyInformation> jobSearchList(HashMap<String, Object> sc);
	List<JobVacancyLookUp> getJobVacancyLookUpListBasic();

	List<JobVacancyLookUp> getJobVacancyLookUpList(HashMap<String, String[]> map);
}
