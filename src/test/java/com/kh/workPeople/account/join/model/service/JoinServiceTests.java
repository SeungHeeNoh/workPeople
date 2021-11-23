package com.kh.workPeople.account.join.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.MemberType;
import com.kh.workPeople.common.vo.Sector;
import com.kh.workPeople.configuration.WorkPeopleApplication;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WorkPeopleApplication.class})
public class JoinServiceTests {
	
	@Autowired
	private JoinService joinService;
	
	
	@Test
	@DisplayName("id 중복 확인")
	@Disabled
	public void testCheckId() {
		int result = joinService.checkId("test1");
		assertNotNull(result);
		assertEquals(0, result);
	}

	@Test
	@DisplayName("기업 종류 test")
	@Disabled
	public void testSelectCompanyTypeList() {
		List<CompanyType> compnayTypeList = joinService.selectCompanyTypeList();
		
		assertNotNull(compnayTypeList);
		for(CompanyType companyType : compnayTypeList) {
			System.out.println(companyType);
		}
	}

	@Test
	@DisplayName("업종 종류 test")
	@Disabled
	public void testSelectSectorList() {
		List<Sector> sectorList = joinService.selectSectorList();
		
		assertNotNull(sectorList);
		for(Sector sector : sectorList) {
			System.out.println(sector);
		}
	}
	

	
}
