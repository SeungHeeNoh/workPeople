package com.kh.workPeople.personal.mypage.interview.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterviewMapper {
    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);
}
