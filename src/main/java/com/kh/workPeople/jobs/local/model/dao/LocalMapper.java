package com.kh.workPeople.jobs.local.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.JobVacancyLookUp;

@Mapper
public interface LocalMapper {

	List<JobVacancyLookUp> getlocalList();
}
