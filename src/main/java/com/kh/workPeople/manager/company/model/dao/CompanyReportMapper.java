package com.kh.workPeople.manager.company.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.JobVacancyReportView;
import com.kh.workPeople.common.vo.PageInfo;

@Mapper
public interface CompanyReportMapper {

	List<JobVacancyReportView> getJvReportList();
	void disableCompanyInfo(HashMap<String, String[]> map);
	void disableJobVacancy(HashMap<String, String[]> map);
	int getListCount();
	List<JobVacancyReportView> selectList(PageInfo pi);
}
