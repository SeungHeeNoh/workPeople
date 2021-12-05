package com.kh.workPeople.personal.mypage.latestPublication.model.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancyLookUp;

public interface LatestPublicationService {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);

	int updateBrowse(Map<String, Object> queryMap);

    Map<String, Object> jobVacancyLookUpListPaging(int no, int page);

    int deleteLatestPublication(Map<String, Object> queryMap);
}
