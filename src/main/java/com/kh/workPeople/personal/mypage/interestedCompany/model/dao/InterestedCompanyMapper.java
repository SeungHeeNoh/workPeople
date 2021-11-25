package com.kh.workPeople.personal.mypage.interestedCompany.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestedCompanyMapper {

    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);

}
