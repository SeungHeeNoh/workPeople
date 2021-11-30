package com.kh.workPeople.companyInformation.model.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.configuration.WorkPeopleApplication;

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
		CompanyInformation companyInformation = companyInformationMapper.getCompanyInformation(2);
		
		assertNotNull(companyInformation);
		log.info(companyInformation.toString());
	}
	
	@Test
	public void testGetCompanyInformationFail() {
		CompanyInformation companyInformation = companyInformationMapper.getCompanyInformation(20);
		
		assertNull(companyInformation);
//		log.info(companyInformation.toString());
	}
}
