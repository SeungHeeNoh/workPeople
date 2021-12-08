package com.kh.workPeople.company.mypage.jvManage.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.JobVacancy;

@Mapper
public interface jvManageMapper {

	List<JobVacancy> jobVacancyInfoSelect(int cino);

}
