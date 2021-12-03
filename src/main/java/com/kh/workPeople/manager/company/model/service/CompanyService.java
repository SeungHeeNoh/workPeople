package com.kh.workPeople.manager.company.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.ManagerCompanyInfo;

public interface CompanyService {


	Map<String, Object> clist(int page);

	ManagerCompanyInfo vacancyNo(int no); 
	
	List<JobVacancy> getJobVacancyListByCompanyNum(int no);



}
