package com.kh.workPeople.jobs.local.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.jobs.local.model.dao.LocalMapper;


@Service
public class LocalListServiceImpl implements LocalListService{
	
	private LocalMapper mapper;
	
	@Autowired
	public LocalListServiceImpl(LocalMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public List<JobVacancyLookUp> getLocalVacancyLookUpList(String[] local) {
		HashMap<String,String[]> map = new HashMap<>(); 
		map.put("local", local);
		
		return mapper.getJobVacancyLookUpList(map);
	}

	@Override
	public List<JobVacancyLookUp> getLocalVacancyLookUpListBasic() {
		return mapper.getJobVacancyLookUpListBasic();
	}


	

}
