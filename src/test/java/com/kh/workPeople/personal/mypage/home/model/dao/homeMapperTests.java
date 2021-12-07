package com.kh.workPeople.personal.mypage.home.model.dao;

import com.kh.workPeople.configuration.WorkPeopleApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WorkPeopleApplication.class})
public class homeMapperTests {

    @Autowired
    private HomeMapper homeMapper;

    @Test
    public void testApplyCompanyYN(){
//        Map<String, Integer> queryMap = new HashMap<>();
//        queryMap.put("no",4);
//        queryMap.put("jvNo",3);

        int result = homeMapper.applyCompanyYN(4,3);

        assertEquals(result,1);

    }



}
