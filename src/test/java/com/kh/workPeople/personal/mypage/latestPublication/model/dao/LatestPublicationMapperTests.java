package com.kh.workPeople.personal.mypage.latestPublication.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

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
public class LatestPublicationMapperTests {

	@Autowired
	private LatestPublicationMapper latestPublicationMapper;
	
	@Test
	public void testGetBrowseCount() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("no", 1);
		queryMap.put("userNo", 1);
		
		int result = latestPublicationMapper.getBrowseCount(queryMap);
		
		assertEquals(result, 1);
	}
	
	@Test
	@Transactional
	public void testDeleteBrowse() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("no", 1);
		queryMap.put("userNo", 1);
		
		int result = latestPublicationMapper.deleteBrowse(queryMap);
		
		assertEquals(result, 1);
	}
	
	@Test
	@Transactional
	public void testInsertBrowse() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("no", 1);
		queryMap.put("userNo", 1);
		
		int result = latestPublicationMapper.insertBrowse(queryMap);
		
		assertEquals(result, 1);
	}
}
