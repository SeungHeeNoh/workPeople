package com.kh.workPeople.personal.mypage.scrap.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;

import java.util.List;

public interface ScrapService {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);
}
