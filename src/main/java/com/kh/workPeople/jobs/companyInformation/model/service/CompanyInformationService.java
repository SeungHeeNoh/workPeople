package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyData;

public interface CompanyInformationService {

	CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap);

	JobVacancyData getProgressingJobVacancyData(Map<String, Object> queryMap, int page);

	JobVacancyData getExpireJobVacancydData(Map<String, Object> queryMap, int page);

	List<Resume> getResumeList(int userNo);

}
