package com.kh.workPeople.jobs.vacancyDetail.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@Mapper
public interface VacancyDetailMapper {
	JobVacancyInformation selectJobVacancyInformation(Map<String, Object> queryMap);

	void increaseCount(int no);
}
