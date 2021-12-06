package com.kh.workPeople.manager.company.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancyReportView;

public interface CompanyReportService {



	List<JobVacancyReportView> getJvReportList();
	void disableJobVacancy(String[] no);
}
