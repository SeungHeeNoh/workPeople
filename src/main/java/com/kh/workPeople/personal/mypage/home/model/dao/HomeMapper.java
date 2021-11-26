package com.kh.workPeople.personal.mypage.home.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {

    Resume selectResumeStatusY(int no);

    List<JobVacancyLookUp> recommenedJobVacancyList(String elName);

}
