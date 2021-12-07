package com.kh.workPeople.jobs.vacancyDetail.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Resume;
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

	@Override
	public List<Resume> getResumeList(int userNo) {
		return vacancyDetailMapper.getResumeList(userNo);
	}


}
