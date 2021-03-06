package com.kh.workPeople.company.mypage.jvManage.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.company.mypage.jvManage.model.dao.jvManageMapper;

@Service
public class jvManageServiceImpl implements jvManageService{

	private jvManageMapper jvManageMapper;
	
	@Autowired
	public jvManageServiceImpl(jvManageMapper jvManageMapper) {
		this.jvManageMapper = jvManageMapper;
	}
	
	@Override
	public List<JobVacancy> jobVacancyInfoSelect(int cino) {
		
		return jvManageMapper.jobVacancyInfoSelect(cino);
	}

	@Override
	public List<JobVacancy> jobVacancyInfoSelectEnd(int cino) {

		return jvManageMapper.jobVacancyInfoSelectEnd(cino);
	}

	@Override
	public Map<String, Object> getJvList(int page, int cino) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> noMap = new HashMap<>();
		
		int listCount = jvManageMapper.getJvListCount(cino);
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		noMap.put("pi", pi);
		noMap.put("cino", cino);
		
		List<JobVacancy> jobVacancy = jvManageMapper.getJvList(noMap);
		
		returnMap.put("pi", pi);
		returnMap.put("jobVacancy", jobVacancy);
		
		return returnMap;
	}


	

}
