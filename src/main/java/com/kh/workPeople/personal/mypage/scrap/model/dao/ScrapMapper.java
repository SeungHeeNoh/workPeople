package com.kh.workPeople.personal.mypage.scrap.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScrapMapper {

    List<JobVacancyLookUp> jobVacancyLookUpList(int no);

	int insertScrap(Map<String, Integer> queryMap);

	int deleteScrap(Map<String, Integer> queryMap);

}
