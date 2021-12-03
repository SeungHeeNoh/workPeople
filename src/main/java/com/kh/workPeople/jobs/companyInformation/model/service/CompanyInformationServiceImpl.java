package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.jobs.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;

@Service
public class CompanyInformationServiceImpl implements CompanyInformationService {
	
	private CompanyInformationMapper companyInformationMapper;
	
	@Autowired
	public CompanyInformationServiceImpl(CompanyInformationMapper companyInformationMapper) {
		this.companyInformationMapper = companyInformationMapper;
	}

	@Override
	public CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap) {
		return companyInformationMapper.getCompanyDetailInformation(queryMap);
	}

}
