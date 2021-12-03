package com.kh.workPeople.personal.mypage.interestedCompany.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kh.workPeople.configuration.WorkPeopleApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WorkPeopleApplication.class})
public class InterestedCompanyMapperTests {
	
	@Autowired
	private InterestedCompanyMapper interestedCompanyMapper;
	
	@Test
	@Transactional
	public void testInsertInterestedCompany() {
		Map<String, Integer> queryMap = new HashMap<>();
		queryMap.put("userNo", 1);
		queryMap.put("companyNo", 1);
		
		int result = interestedCompanyMapper.insertInterestedCompany(queryMap);
		
		assertEquals(result, 1);
	}

	@Test
	@Transactional
	@Disabled
	public void testDeleteInterestedCompany() {
		Map<String, Integer> queryMap = new HashMap<>();
		queryMap.put("userNo", 1);
		queryMap.put("companyNo", 1);
		
		int result = interestedCompanyMapper.deleteInterestedCompany(queryMap);
		
		assertEquals(result, 1);
	}
	
	@Disabled
	@Test
	public void testGetInterestedCompanyCount() {
		int result = interestedCompanyMapper.getInterestedCompanyCount(1);
		
		assertEquals(result, 2);
	}

}
