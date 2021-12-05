package com.kh.workPeople.personal.mypage.latestPublication.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LatestPublicationMapper {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);
    
    int getBrowseCount(Map<String, Object> queryMap);
    
    int deleteBrowse(Map<String, Object> queryMap);

	int insertBrowse(Map<String, Object> queryMap);

    List<JobVacancyLookUp> jobVacancyLookUpListPagingQuery(PageInfo pi);

    int deleteLatestPublication(Map<String, Object> queryMap);
}
