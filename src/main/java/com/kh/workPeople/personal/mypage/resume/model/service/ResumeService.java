package com.kh.workPeople.personal.mypage.resume.model.service;

import com.kh.workPeople.common.vo.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> resumeList(int no);

    int resumeBrowseCount(int repResumeNo);

    int applyCompanyCount(int repResumeNo);
}
