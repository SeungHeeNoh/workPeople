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
	public Member memberInfoselect(String userId) {
		return companyMainMapper.memberInfoselect(userId);
	}

	@Override
	public CompanyInformation companyInfoSelect(int userNo) {
		return companyMainMapper.companyInfoSelect(userNo);
	}

	@Override
	public JobVacancy jobVacancyInfoSelect(int ciNo) {
		return companyMainMapper.jobVacancyInfoSelect(ciNo);
	}

	@Override
	public int jvIngCount(int no) {
		return companyMainMapper.jvIngCount(no);
	}

	


	
	
	
	

}
