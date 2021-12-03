package com.kh.workPeople.jobs.local.service;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancyLookUp;

public interface LocalListService {


	List<JobVacancyLookUp> getLocalVacancyLookUpList(String[] local);
	List<JobVacancyLookUp> getLocalVacancyLookUpListBasic();
	
}
