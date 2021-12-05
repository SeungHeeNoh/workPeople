package com.kh.workPeople.personal.mypage.interestedCompany.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
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
	@Disabled
	public void testGetInterestedCompanyCount() {
		int result = interestedCompanyMapper.getInterestedCompanyCount(1);
		
		assertEquals(result, 2);
	}
	
    @Test
    @Transactional
    public void testDeleteScrapList() {
        List<Integer> companyNoList = new ArrayList<>();
        companyNoList.add(1);
        companyNoList.add(2);
        companyNoList.add(3);
        
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userNo", 4);
        queryMap.put("companyNoList", companyNoList);
        
        int result = interestedCompanyMapper.deleteInterestedCompanyList(queryMap);
        
        assertNotEquals(result, 0);
    }

}
