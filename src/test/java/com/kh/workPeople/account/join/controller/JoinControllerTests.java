package com.kh.workPeople.account.join.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kh.workPeople.configuration.WorkPeopleApplication;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WorkPeopleApplication.class})
public class JoinControllerTests {

	@Autowired
	private JoinController joinController;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(joinController).build();
	}
	
	@Test
	@DisplayName("company-join 진입")
	public void testCompanyJoin() throws Exception {
		mockMvc.perform(get("/account/join/company-join"))
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("사업자등록번호 확인")
	public void testCheckRegisterNumber() throws Exception {
		mockMvc.perform(get("/account/join/checkRegisterNumber/1448101176"))
			.andExpect(status().isOk())
			.andDo(print());
		
	}
}
