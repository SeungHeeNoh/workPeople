package com.kh.workPeople.company.mypage.jvManage.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancy;

public interface jvManageService {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

	List<JobVacancy> jobVacancyInfoSelectEnd(int cino);

	Map<String, Object> getJvList(int page, int cino);


}
