package com.kh.workPeople.company.mypage.personalManage.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.company.mypage.personalManage.model.dao.personalManageMapper;

@Service
public class personalManageServiceImpl implements personalManageService{

	private personalManageMapper personalManageMapper;
	
	@Autowired
	public personalManageServiceImpl(personalManageMapper personalManageMapper) {
		this.personalManageMapper = personalManageMapper;
	}
	
	@Override
	public List<JobVacancy> jobVacancyInfoSelect(int cino) {
		
		return personalManageMapper.jobVacancyInfoSelect(cino);
	}

	@Override
	public Map<String, Object> getJvList(int page, int cino) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> noMap = new HashMap<>();
		
		int listCount = personalManageMapper.getJvListCount(cino);
		
		PageInfo pi = new PageInfo(page, listCount, 1, 10);
		
		noMap.put("pi", pi);
		noMap.put("cino", cino);
		
		List<JobVacancy> jobVacancy = personalManageMapper.getJvList(noMap);
		
		returnMap.put("pi", pi);
		returnMap.put("jobVacancy", jobVacancy);
		
		return returnMap;
	}
	
	

}
