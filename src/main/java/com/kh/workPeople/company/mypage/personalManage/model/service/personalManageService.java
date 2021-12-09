package com.kh.workPeople.company.mypage.personalManage.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancy;

public interface personalManageService {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

	Map<String, Object> getJvList(int page, int cino);

}
