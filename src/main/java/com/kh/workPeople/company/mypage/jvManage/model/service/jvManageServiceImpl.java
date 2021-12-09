package com.kh.workPeople.company.mypage.jvManage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.JobVacancy;
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

}
