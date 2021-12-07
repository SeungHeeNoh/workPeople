package com.kh.workPeople.personal.mypage.interview.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterviewMapper {
    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);

    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleListPagingQuery(PageInfo pi);

    int deleteInterviewList(int aiNo);
}
