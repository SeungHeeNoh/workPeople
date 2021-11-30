package com.kh.workPeople.personal.mypage.resume.model.dao;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.ResumeDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {

    List<Resume> resumeList(int no);

    int resumeBrowseCount(int repResumeNo);

    int applyCompanyCount(int repResumeNo);

    ResumeDetails resumeDetailsLookUp(int rNo);

    ResumeDetails resumeDetailsLookUpFormat(int rNo);

}
