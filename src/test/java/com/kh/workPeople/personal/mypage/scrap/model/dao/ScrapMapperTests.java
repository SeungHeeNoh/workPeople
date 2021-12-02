package com.kh.workPeople.personal.mypage.scrap.model.dao;

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
public class ScrapMapperTests {

	@Autowired
	private ScrapMapper scrapMapper;
	
	@Test
	@Transactional
	@Disabled
	public void testInsertScrap() {
		Map<String, Integer> queryMap = new HashMap<>();
		queryMap.put("userNo", 1);
		queryMap.put("jobVacancyNo", 1);
		
		int result = scrapMapper.insertScrap(queryMap);
		
		assertEquals(result, 1);
	}
	
	@Test
	@Transactional
	public void testDeleteScrap() {
		Map<String, Integer> queryMap = new HashMap<>();
		queryMap.put("userNo", 1);
		queryMap.put("jobVacancyNo", 1);
		
		int result = scrapMapper.deleteScrap(queryMap);
		
		assertEquals(result, 1);
	}

}
