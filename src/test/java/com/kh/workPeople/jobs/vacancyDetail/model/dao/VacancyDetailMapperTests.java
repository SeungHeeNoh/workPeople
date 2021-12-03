package com.kh.workPeople.jobs.vacancyDetail.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.configuration.WorkPeopleApplication;
import com.kh.workPeople.jobs.vacancyDetail.model.vo.JobVacancyInformation;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WorkPeopleApplication.class})
public class VacancyDetailMapperTests {

	@Autowired
	private VacancyDetailMapper vacancyDetailMapper;
	
	@Test
	public void testSelectCompanyTypeList() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("no", 1);
		queryMap.put("userNo", 4);
		
		JobVacancyInformation jobVacancy = vacancyDetailMapper.selectJobVacancyInformation(queryMap);
		
		System.out.println(jobVacancy);
	} 
}
