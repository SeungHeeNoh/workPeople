package com.kh.workPeople.company.mypage.personalManage.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.JobVacancy;

@Mapper
public interface personalManageMapper {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

	int getJvListCount(int cino);

	List<JobVacancy> getJvList(Map<String, Object> noMap);


}
