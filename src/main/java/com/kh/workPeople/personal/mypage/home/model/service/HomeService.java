package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;

import java.util.List;

public interface HomeService {

    Resume selectResumeStatusY(int no);

    int applyCount(int no);

    int resumeBrowseCount(int no);

    int scrapCount(int no);

    int interestedCompanyCount(int no);

    int chatCount(int no);

    List<JobVacancyLookUp> recommenedJobVacancyList(String elName);

    int resumeDelete(int rNo);

    int applyCompanyYN(int no, int jvNo);
}
