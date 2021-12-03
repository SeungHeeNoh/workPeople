package com.kh.workPeople.personal.mypage.scrap.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScrapMapper {

    List<JobVacancyLookUp> jobVacancyLookUpList(int no);

    List<JobVacancyLookUp> jobVacancyLookUpListPagingQuery(PageInfo pi);

    Map<String, Object> jobVacancyLookUpListPaging(int no, int page);
}
