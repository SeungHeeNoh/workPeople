package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.Resume;

public interface HomeService {

    Resume selectResumeStatusY(int no);

    int applyCount(int no);

    int resumeBrowseCount(int no);

    int scrapCount(int no);

    int interestedCompanyCount(int no);

    int chatCount(int no);
}
