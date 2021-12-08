package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyAndPageInfo;

public interface CompanyInformationService {

	CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap);

	JobVacancyAndPageInfo getProgressingJobVacancyData(Map<String, Object> queryMap, int page);

	JobVacancyAndPageInfo getExpireJobVacancydData(Map<String, Object> queryMap, int page);

	List<Resume> getResumeList(int userNo);

}
