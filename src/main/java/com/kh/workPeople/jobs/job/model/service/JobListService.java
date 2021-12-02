package com.kh.workPeople.jobs.job.model.service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Sector;

import java.util.List;

public interface JobListService {
	
	List<Sector> getSectorList();

	List<CompanyInformation> jobSearchList(String[] no);
	List<JobVacancyLookUp> getJobVacancyLookUpList(String[] no);
	List<JobVacancyLookUp> getJobVacancyLookUpListBasic();
}
