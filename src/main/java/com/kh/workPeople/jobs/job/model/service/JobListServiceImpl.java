package com.kh.workPeople.jobs.job.model.service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Sector;
import com.kh.workPeople.jobs.job.model.dao.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class JobListServiceImpl implements JobListService{
	
	private JobMapper mapper;
	
	@Autowired
	public JobListServiceImpl(JobMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Sector> getSectorList() {
		return mapper.getSectorList();
		
	}

	@Override
	public List<CompanyInformation> jobSearchList(String[] no) {
		HashMap<String, Object> sc = new HashMap<String, Object>();
		sc.put("no",no);
		return mapper.jobSearchList(sc);
	}

	@Override
	public List<JobVacancyLookUp> getJobVacancyLookUpList(String[] no) {
		HashMap<String,String[]> map = new HashMap<>(); 
		map.put("no", no);

		return mapper.getJobVacancyLookUpList(map);
	}

	@Override
	public List<JobVacancyLookUp> getJobVacancyLookUpListBasic() {
		return mapper.getJobVacancyLookUpListBasic();
	}

}
