package com.kh.workPeople.jobs.vacancyDetail.model.service;

import java.util.Map;

import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

public interface VacancyDetailService {
	JobVacancyInformation selectJobVacancyInformation(Map<String, Object> queryMap);
}
