package com.kh.workPeople.account.findIdPwd.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kh.workPeople.configuration.WorkPeopleApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WorkPeopleApplication.class})
public class FindIdPwdMapperTests {
	
	@Autowired
	private FindIdPwdMapper findIdPwdMapper;

	
}
