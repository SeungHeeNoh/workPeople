package com.kh.workPeople.main.model.service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MainTier;
import com.kh.workPeople.common.vo.Sector;
import com.kh.workPeople.jobs.job.model.dao.JobMapper;
import com.kh.workPeople.main.model.dao.MainMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class MainServiceImpl implements MainService{
	
	private MainMapper mapper;
	
	@Autowired
	public MainServiceImpl(MainMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int getJvCount() {
		return mapper.getJvCount();
	}

	@Override
	public int getSkCount() {
		return mapper.getSkCount();
	}

	@Override
	public int getCmCount() {
		return mapper.getCmCount();
	}

	@Override
	public List<MainTier> getPlatinumList() {
		return mapper.getPlatinumList();
	}

	@Override
	public List<MainTier> getBasicList() {
		return mapper.getBasicList();
	}

	

}
