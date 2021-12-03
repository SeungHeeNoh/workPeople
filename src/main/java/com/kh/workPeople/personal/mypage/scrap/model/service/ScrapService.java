package com.kh.workPeople.personal.mypage.scrap.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;

import java.util.List;
import java.util.Map;

public interface ScrapService {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);


    Map<String, Object> jobVacancyLookUpListPaging(int no, int page);

    
    int deleteScrapList(Map<String, Object> queryMap);

	int insertScrap(Map<String, Integer> queryMap);

	int deleteScrap(Map<String, Integer> queryMap);

}
