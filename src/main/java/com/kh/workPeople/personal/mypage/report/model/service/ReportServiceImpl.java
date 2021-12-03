package com.kh.workPeople.personal.mypage.report.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.personal.mypage.report.model.dao.ReportMapper;

@Service
public class ReportServiceImpl implements ReportService {
	
	private ReportMapper reportMapper;
	
	@Autowired
	public ReportServiceImpl(ReportMapper reportMapper) {
		this.reportMapper = reportMapper;
	}

	@Override
	public int insertReportVacancy(Map<String, Integer> queryMap) {
		return reportMapper.insertReportVacancy(queryMap);
	}

}
