package com.kh.workPeople.manager.company.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancyReportView;

public interface CompanyReportService {

	Map<String, Object> getJvReportList(int page);
	List<JobVacancyReportView> getJvReportList(); 
	void disableJobVacancy(String[] no);
}
