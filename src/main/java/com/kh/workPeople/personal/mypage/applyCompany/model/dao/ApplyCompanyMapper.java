package com.kh.workPeople.personal.mypage.applyCompany.model.dao;

import com.kh.workPeople.common.vo.ApplyCompany;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.ResumeDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyCompanyMapper {

    int applyCount(int no);

    int passCount(int no);

    int interviewCount(int no);

    int passAllCount(int no);

    int failureCount(int no);

    List<JobVacancyLookUp> jobVacancyLookUpList(int no);

    int applyCompany(int rNo, int applyBtnNo);

    List<JobVacancyLookUp> jobVacancyLookUpListPagingQuery(PageInfo pi);

    JobVacancyLookUp applyCompanyRbDateFormat(int jvNo);

    int insertappliedBasicInfo(ResumeDetails basicInfoAndEducation);

    ApplyCompany selectApplyCompany(int rNo, int applyBtnNo);
}
