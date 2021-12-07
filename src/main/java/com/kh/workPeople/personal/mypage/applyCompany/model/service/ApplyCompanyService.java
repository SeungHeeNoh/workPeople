package com.kh.workPeople.personal.mypage.applyCompany.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.ResumeDetails;

import java.util.List;
import java.util.Map;

public interface ApplyCompanyService {

    int applyCount(int no);

    int passCount(int no);

    int interviewCount(int no);

    int passAllCount(int no);

    int failureCount(int no);

    List<JobVacancyLookUp> jobVacancyLookUpList(int no);

    int applyCompany(int rNo, int applyBtnNo);

    int insertAppliedTable(int rNo, int applyBtnNo);

    Map<String, Object> jobVacancyLookUpListPaging(int no, int page);

    JobVacancyLookUp applyCompanyRbDateFormat(int jvNo);

}
