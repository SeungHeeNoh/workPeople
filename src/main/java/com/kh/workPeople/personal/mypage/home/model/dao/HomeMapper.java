package com.kh.workPeople.personal.mypage.home.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.Resume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {

    Resume selectResumeStatusY(int no);

    int applyCount(int no);

    int resumeBrowseCount(int no);

    int scrapCount(int no);

    int interestedCompanyCount(int no);

    int chatCount(int no);

    List<JobVacancyLookUp> recommenedJobVacancyList(String elName);

    int applyCompanyYN(int no, int jvNo);

    int resumeDeleteFromDB(int rNo);


    int basicInfoDeleteFromDB(int rNo);

    int educationDeleteFromDB(int rNo);

    int careerDeleteFromDB(int rNo);

    int activityDeleteFromDB(int rNo);

    int licenseDeleteFromDB(int rNo);

    int languageDeleteFromDB(int rNo);

    int awardsDeleteFromDB(int rNo);

    int selfIntroductionDeleteFromDB(int rNo);

    int resumeBrowseDeleteFromDB(int rNo);

    List<JobVacancyLookUp> jobVacancyLookUpListPagingQuery(PageInfo pi);
}
