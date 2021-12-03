package com.kh.workPeople.personal.mypage.latestPublication.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LatestPublicationMapper {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);
    
    int getBrowseCount(Map<String, Object> queryMap);
    
    int deleteBrowse(Map<String, Object> queryMap);

	int insertBrowse(Map<String, Object> queryMap);

}
