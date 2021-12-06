package com.kh.workPeople.manager.company.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.workPeople.common.vo.JobVacancyReportView;
import com.kh.workPeople.manager.company.model.dao.CompanyReportMapper;

@Service
public class CompanyReportServiceImpl implements CompanyReportService{
	
	private CompanyReportMapper mapper;
	
	@Autowired
	public CompanyReportServiceImpl(CompanyReportMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<JobVacancyReportView> getJvReportList() {
		return mapper.getJvReportList();
	}

	@Override
	public void disableJobVacancy(String[] no) {
		HashMap<String, String[]> map = new HashMap<>();
		map.put("no", no);
		 mapper.disableJobVacancy(map);
	}
	
	
	

	
}