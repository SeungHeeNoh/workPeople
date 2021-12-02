package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.Map;

import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;

public interface CompanyInformationService {

	CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap);

}
