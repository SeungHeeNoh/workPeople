package com.kh.workPeople.jobs.vacancyDetail.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@Mapper
public interface VacancyDetailMapper {
	JobVacancyInformation selectJobVacancyInformation(int no);
}
