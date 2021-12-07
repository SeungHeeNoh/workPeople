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
	public Member memberInfoSelect(String userId) {
		
		return companyMainMapper.memberInfoSelect(userId);
	}

	@Override
	public CompanyInformation companyInfoSelect(int userNo) {
		
		return companyMainMapper.companyInfoSelect(userNo);
	}

	@Override
	public JobVacancy jvInfoSelect(int ciNo) {
		
		return companyMainMapper.jvInfoSelect(ciNo);
	}

	@Override
	public List<JobVacancy> findAllJvList() {
		
		return companyMainMapper.findAllJvList();
	}

}
