package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.jobs.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.ExpiredJobVacancyData;
import com.kh.workPeople.jobs.companyInformation.model.vo.ProgressingJobVacancyData;

@Service
public class CompanyInformationServiceImpl implements CompanyInformationService {
	
	private CompanyInformationMapper companyInformationMapper;
	
	@Autowired
	public CompanyInformationServiceImpl(CompanyInformationMapper companyInformationMapper) {
		this.companyInformationMapper = companyInformationMapper;
	}

	@Override
	public CompanyDetailInformation getCompanyDetailInformation(Map<String, Object> queryMap) {
		CompanyDetailInformation companyDetailInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		if(companyDetailInformation != null) {
			ProgressingJobVacancyData progressingJobVacancyData = new ProgressingJobVacancyData();
			ExpiredJobVacancyData expiredJobVacancyData = new ExpiredJobVacancyData();

			queryMap.put("sign", ">=");
			PageInfo progressJVPi = new PageInfo(1, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);  
			queryMap.put("pi", progressJVPi);
			
			progressingJobVacancyData.setPageInfo(progressJVPi);
			progressingJobVacancyData.setProgressingJobVacancyList(companyInformationMapper.getJobVacancyList(queryMap));
			

			queryMap.put("sign", "<");
			PageInfo ExpiredJVPi = new PageInfo(1, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);
			queryMap.put("pi", ExpiredJVPi);
			
			expiredJobVacancyData.setPageInfo(ExpiredJVPi);
			expiredJobVacancyData.setExpiredJobVacancyList(companyInformationMapper.getJobVacancyList(queryMap));
			
			companyDetailInformation.setProgressingJobVacancyData(progressingJobVacancyData);
			companyDetailInformation.setExpiredJobVacancyData(expiredJobVacancyData);
		}
		
		return companyDetailInformation;
	}

}
