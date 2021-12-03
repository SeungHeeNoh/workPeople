package com.kh.workPeople.personal.mypage.report.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {

	int insertReportVacancy(Map<String, Integer> queryMap);

}
