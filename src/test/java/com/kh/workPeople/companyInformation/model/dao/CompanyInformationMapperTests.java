package com.kh.workPeople.companyInformation.model.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.common.vo.CompanyInformation;
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
		queryMap.put("companyInformationNo", 2);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNotNull(companyInformation);
		log.info(companyInformation.toString());
	}
	
	@Test
	public void testGetCompanyInformationFail() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 20);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNull(companyInformation);
//		log.info(companyInformation.toString());
	}
	
	@Test
	public void testGetCompanyInformationAndUser() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("companyInformationNo", 1);
		queryMap.put("userNo", 4);
		CompanyDetailInformation companyInformation = companyInformationMapper.getCompanyDetailInformation(queryMap);
		
		assertNotNull(companyInformation);
		log.info(companyInformation.toString());
	}
}
