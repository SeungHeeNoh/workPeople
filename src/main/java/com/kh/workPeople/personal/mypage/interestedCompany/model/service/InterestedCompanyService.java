package com.kh.workPeople.personal.mypage.interestedCompany.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;

import java.util.List;
import java.util.Map;

public interface InterestedCompanyService {
    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);

    int jobVacancyCount(int no);

	int insertInterestedCompany(Map<String, Integer> queryMap);
}
