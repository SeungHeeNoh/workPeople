package com.kh.workPeople.personal.mypage.interestedCompany.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InterestedCompanyMapper {

    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);

    int jobVacancyCount(int no);

	int insertInterestedCompany(Map<String, Integer> queryMap);

	int deleteInterestedCompany(Map<String, Integer> queryMap);

	int getInterestedCompanyCount(int companyNo);

}
