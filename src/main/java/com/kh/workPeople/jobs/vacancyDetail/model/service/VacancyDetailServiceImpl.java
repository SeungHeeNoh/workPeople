package com.kh.workPeople.jobs.vacancyDetail.model.service;

import java.util.Map;

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
	public void increaseCount(int no) {
		vacancyDetailMapper.increaseCount(no);
	}

	@Override
	public JobVacancyInformation selectJobVacancyInformation(Map<String, Object> queryMap) {
		return vacancyDetailMapper.selectJobVacancyInformation(queryMap);
	}

}
