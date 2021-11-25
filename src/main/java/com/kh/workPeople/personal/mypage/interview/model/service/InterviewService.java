package com.kh.workPeople.personal.mypage.interview.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;

import java.util.List;

public interface InterviewService {
    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);
}
