package com.kh.workPeople.company.mypage.insertJv.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.insertJv.model.dao.insertJvMapper;

@Service
public class insertJvServiceImpl implements insertJvService{
	
	private insertJvMapper insertJvMapper;

	@Autowired
	public insertJvServiceImpl(insertJvMapper insertJvMapper) {
		this.insertJvMapper = insertJvMapper;
	}
	
	@Override
	public Member memberInfoselect(String userId) {
		return insertJvMapper.memberInfoselect(userId);
	}

	@Override
	public CompanyInformation companyInfoSelect(int userNo) {
		return insertJvMapper.companyInfoSelect(userNo);
	}

	@Override
	public JobVacancy jobVacancyInfoSelect(int ciNo) {
		return insertJvMapper.jobVacancyInfoSelect(ciNo);
	}

	@Override
	public int insertInfo(JobVacancy jobVacancy) {
		return insertJvMapper.registNewJobVacancy(jobVacancy);
		
	}

}
