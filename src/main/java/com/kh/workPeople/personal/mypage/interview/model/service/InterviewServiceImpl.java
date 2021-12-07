package com.kh.workPeople.personal.mypage.interview.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.personal.mypage.interview.model.dao.InterviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterviewServiceImpl implements InterviewService{

    private final InterviewMapper interviewMapper;

    @Autowired
    public InterviewServiceImpl(InterviewMapper interviewMapper) {
        this.interviewMapper = interviewMapper;
    }


    @Override
    public List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no) {
        return interviewMapper.jobVacancyLookUpSimpleList(no);
    }

    @Override
    public Map<String, Object> jobVacancyLookUpSimpleListPaging(int no, int page) {

        Map<String, Object> returnMap = new HashMap<>();

        int listCount = interviewMapper.jobVacancyLookUpSimpleList(no).size();

        PageInfo pi = new PageInfo(page,listCount,10,10,no);

        List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = interviewMapper.jobVacancyLookUpSimpleListPagingQuery(pi);

        returnMap.put("pi",pi);
        returnMap.put("jobVacancyLookUpSimpleList",jobVacancyLookUpSimpleList);

        return returnMap;
    }


    @Override
    public int deleteInterview(List<Integer> aiNoList) {

        System.out.println("serviceimpl ainolist : "+aiNoList);

        int result=0;

        for(Integer aiNo : aiNoList){
            int result2 = interviewMapper.deleteInterviewList(aiNo);
            result += result2;
        }
        return result;
    }
}
