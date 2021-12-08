package com.kh.workPeople.jobs.companyInformation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.jobs.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;
import com.kh.workPeople.jobs.companyInformation.model.vo.JobVacancyAndPageInfo;

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
			JobVacancyAndPageInfo progressingJobVacancyData = getProgressingJobVacancyData(queryMap, 1);
			JobVacancyAndPageInfo expiredJobVacancyData = getExpireJobVacancydData(queryMap, 1);

			companyDetailInformation.setProgressingJobVacancyData(progressingJobVacancyData);
			companyDetailInformation.setExpiredJobVacancyData(expiredJobVacancyData);
		}
		
		return companyDetailInformation;
	}

	@Override
	public JobVacancyAndPageInfo getProgressingJobVacancyData(Map<String, Object> queryMap, int page) {
		JobVacancyAndPageInfo progressingJobVacancyData = new JobVacancyAndPageInfo();
		
		queryMap.put("sign", ">=");

		PageInfo pi = new PageInfo(page, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);
		queryMap.put("pi", pi);
		
		progressingJobVacancyData.setPageInfo(pi);
		progressingJobVacancyData.setJobVacancyDataList(companyInformationMapper.getJobVacancyDataList(queryMap));
		
		return progressingJobVacancyData;
	}

	@Override
	public JobVacancyAndPageInfo getExpireJobVacancydData(Map<String, Object> queryMap, int page) {
		JobVacancyAndPageInfo expiredJobVacancyData = new JobVacancyAndPageInfo();
		
		queryMap.put("sign", "<");
		PageInfo pi = new PageInfo(page, companyInformationMapper.getJobVacancyListCount(queryMap), 5, 6);
		queryMap.put("pi", pi);
		
		expiredJobVacancyData.setPageInfo(pi);
		expiredJobVacancyData.setJobVacancyDataList(companyInformationMapper.getJobVacancyDataList(queryMap));
		
		return expiredJobVacancyData;
	}

	@Override
	public List<Resume> getResumeList(int userNo) {
		return companyInformationMapper.getResumeList(userNo);
	}

}
