package com.kh.workPeople.company.mypage.jvManage.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancy;

public interface jvManageService {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

	List<JobVacancy> jobVacancyInfoSelectEnd(int cino);

}
