package com.kh.workPeople.personal.mypage.latestPublication.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;

import java.util.List;

public interface LatestPublicationService {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);
}
