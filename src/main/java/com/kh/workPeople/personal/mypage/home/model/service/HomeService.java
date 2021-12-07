package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;

import java.util.List;
import java.util.Map;

public interface HomeService {

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

    Map<String, Object> recommenedJobVacancyListPaging(String elName, int page);
}
