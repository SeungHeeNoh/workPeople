package com.kh.workPeople.company.mypage.companyMain.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.PersonInfoResume;
import com.kh.workPeople.company.mypage.companyMain.model.dao.CompanyMainMapper;

@Service
public class CompanyMainServiceImpl implements CompanyMainService{
	
	private CompanyMainMapper companyMainMapper;
	
	@Autowired
	public CompanyMainServiceImpl(CompanyMainMapper companyMainMapper) {
		this.companyMainMapper = companyMainMapper;
	}

	@Override
	public int jvIngCount(int cino) {
		return companyMainMapper.jvIngCount(cino);
	}

	@Override
	public int jvEndCount(int cino) {
		return companyMainMapper.jvEndCount(cino);
	}

	@Override
	public CompanyInformation companyInfoSelect(int cino) {
		return companyMainMapper.companyInfoSelect(cino);
	}

	@Override
	public Map<String, Object> getJvList(int page, int cino) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> noMap = new HashMap<>();
		
		int listCount = companyMainMapper.getListCount(cino);
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		noMap.put("pi", pi);
		noMap.put("cino", cino);
		
		List<JobVacancy> jobVacancy = companyMainMapper.getJvList(noMap);
		
		returnMap.put("pi", pi);
		returnMap.put("jobVacancy", jobVacancy);
		
		return returnMap;
	}

	


	
	
	
	

}
