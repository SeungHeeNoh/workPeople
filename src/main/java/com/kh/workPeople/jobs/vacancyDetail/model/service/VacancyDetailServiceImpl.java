package com.kh.workPeople.jobs.vacancyDetail.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.jobs.vacancyDetail.model.dao.VacancyDetailMapper;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@Service
public class VacancyDetailServiceImpl implements VacancyDetailService {
	
	private VacancyDetailMapper vacancyDetailMapper;
	
	@Autowired
	public VacancyDetailServiceImpl(VacancyDetailMapper vacancyDetailMapper) {
		this.vacancyDetailMapper = vacancyDetailMapper;
	}

	@Override
	public JobVacancyInformation selectJobVacancyInformation(int no) {
		return vacancyDetailMapper.selectJobVacancyInformation(no);
	}
	
}
