package com.kh.workPeople.personal.mypage.interview.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;

import java.util.List;
import java.util.Map;

public interface InterviewService {
    List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no);

    Map<String, Object> jobVacancyLookUpSimpleListPaging(int no, int page);

    int deleteInterview(List<Integer> aiNoList);
}
