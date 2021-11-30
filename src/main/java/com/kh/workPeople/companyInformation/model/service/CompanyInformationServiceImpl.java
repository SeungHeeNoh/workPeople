package com.kh.workPeople.companyInformation.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.companyInformation.model.dao.CompanyInformationMapper;

@Service
public class CompanyInformationServiceImpl implements CompanyInformationService {
	
	private CompanyInformationMapper companyInformationMapper;
	
	@Autowired
	public CompanyInformationServiceImpl(CompanyInformationMapper companyInformationMapper) {
		this.companyInformationMapper = companyInformationMapper;
	}

	@Override
	public Map<String, Object> getCompanyInformation(int no) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("member", companyInformationMapper.getMember(no));
		map.put("companyInformation", companyInformationMapper.getCompanyInformation(no));
		
		return map;
	}

}
