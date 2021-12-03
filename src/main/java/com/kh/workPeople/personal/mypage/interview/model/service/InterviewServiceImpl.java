package com.kh.workPeople.personal.mypage.interview.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.personal.mypage.interview.model.dao.InterviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
