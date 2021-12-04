package com.kh.workPeople.companyInformation.model.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.configuration.WorkPeopleApplication;
import com.kh.workPeople.jobs.companyInformation.model.dao.CompanyInformationMapper;
import com.kh.workPeople.jobs.companyInformation.model.vo.CompanyDetailInformation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WorkPeopleApplication.class})
public class CompanyInformationMapperTests {

	@Autowired
	private CompanyInformationMapper companyInformationMapper;
	
	@Test
	public void testGetCompanyInformationSuccess() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 1);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNotNull(companyInformation);
//		log.info(companyInformation.toString());
	}
	
	@Test
	@Disabled
	public void testGetCompanyInformationFail() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 20);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNull(companyInformation);
//		log.info(companyInformation.toString());
	}
	
	@Test
	@Disabled
	public void testGetCompanyInformationAndUser() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 1);
		queryMap.put("userNo", 4);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNotNull(companyInformation);
		log.info(companyInformation.toString());
	}
	
	@Test
	public void testGetExpiredJobVacancyList() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 1);
		queryMap.put("findBy", "expired");
		
		List<JobVacancy> progressingJobVacancyList = companyInformationMapper.getJobVacancyList(queryMap);
		
		for(JobVacancy job : progressingJobVacancyList) {
			log.info(job.toString());
		}
		
	}
}
