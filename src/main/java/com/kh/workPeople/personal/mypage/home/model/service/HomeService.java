package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;

import java.util.List;

public interface HomeService {

    Resume selectResumeStatusY(int no);

    List<JobVacancyLookUp> recommenedJobVacancyList(String elName);
}
