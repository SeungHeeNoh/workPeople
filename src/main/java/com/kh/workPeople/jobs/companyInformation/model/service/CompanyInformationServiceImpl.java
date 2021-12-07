package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.jobs.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyData;

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
			JobVacancyData progressingJobVacancyData = getProgressingJobVacancyData(queryMap, 1);
			JobVacancyData expiredJobVacancyData = getExpireJobVacancydData(queryMap, 1);

			companyDetailInformation.setProgressingJobVacancyData(progressingJobVacancyData);
			companyDetailInformation.setExpiredJobVacancyData(expiredJobVacancyData);
		}
		
		return companyDetailInformation;
	}

	@Override
	public JobVacancyData getProgressingJobVacancyData(Map<String, Object> queryMap, int page) {
		JobVacancyData progressingJobVacancyData = new JobVacancyData();
		
		queryMap.put("sign", ">=");

		PageInfo pi = new PageInfo(page, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);
		queryMap.put("pi", pi);
		
		progressingJobVacancyData.setPageInfo(pi);
		progressingJobVacancyData.setJobVacancyList(companyInformationMapper.getJobVacancyList(queryMap));
		
		return progressingJobVacancyData;
	}

	@Override
	public JobVacancyData getExpireJobVacancydData(Map<String, Object> queryMap, int page) {
		JobVacancyData expiredJobVacancyData = new JobVacancyData();
		
		queryMap.put("sign", "<");
		PageInfo pi = new PageInfo(page, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);
		queryMap.put("pi", pi);
		
		expiredJobVacancyData.setPageInfo(pi);
		expiredJobVacancyData.setJobVacancyList(companyInformationMapper.getJobVacancyList(queryMap));
		
		return expiredJobVacancyData;
	}

	@Override
	public List<Resume> getResumeList(int userNo) {
		return companyInformationMapper.getResumeList(userNo);
	}

}
