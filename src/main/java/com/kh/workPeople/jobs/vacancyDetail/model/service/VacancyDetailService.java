package com.kh.workPeople.jobs.vacancyDetail.model.service;

import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

public interface VacancyDetailService {
	JobVacancyInformation selectJobVacancyInformation(int no);
}
