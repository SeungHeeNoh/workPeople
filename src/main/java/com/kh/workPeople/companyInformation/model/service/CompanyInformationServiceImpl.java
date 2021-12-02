package com.kh.workPeople.companyInformation.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.companyInformation.model.vo.CompanyDetailInformation;

@Service
public class CompanyInformationServiceImpl implements CompanyInformationService {
	
	private CompanyInformationMapper companyInformationMapper;
	
	@Autowired
	public CompanyInformationServiceImpl(CompanyInformationMapper companyInformationMapper) {
		this.companyInformationMapper = companyInformationMapper;
	}

	@Override
	public CompanyDetailInformation getCompanyDetailInformation(int no) {
		CompanyDetailInformation companyDetailInformation = companyInformationMapper.getCompanyDetailInformation(no);
		
		return companyDetailInformation;
	}

}
