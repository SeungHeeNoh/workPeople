package com.kh.workPeople.company.mypage.companyMain.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.companyMain.model.dao.CompanyMainMapper;

@Service
public class CompanyMainServiceImpl implements CompanyMainService{
	
	private CompanyMainMapper companyMainMapper;
	
	@Autowired
	public CompanyMainServiceImpl(CompanyMainMapper companyMainMapper) {
		this.companyMainMapper = companyMainMapper;
	}

	@Override
	public List<JobVacancy> jobVacancyInfoSelect(int cino) {
		return companyMainMapper.jobVacancyInfoSelect(cino);
	}

	@Override
	public int jvIngCount(int cino) {
		return companyMainMapper.jvIngCount(cino);
	}

	@Override
	public int jvEndCount(int cino) {
		return companyMainMapper.jvEndCount(cino);
	}

	


	
	
	
	

}
