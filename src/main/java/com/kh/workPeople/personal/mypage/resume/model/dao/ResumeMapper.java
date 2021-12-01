package com.kh.workPeople.personal.mypage.resume.model.dao;

import com.kh.workPeople.common.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {

    List<Resume> resumeList(int no);

    int resumeBrowseCount(int repResumeNo);

    int applyCompanyCount(int repResumeNo);

    // 이력서 정보 조회(기본정보,학력)
    ResumeDetails resumeDetailsLookUp(int rNo);
    // 이력서 정보 조회(기본정보,학력의 나이->만나이,한국나이 포멧, util.Date->string 포멧(YYYY.MM)
    ResumeDetails resumeDetailsLookUpFormat(int rNo);
    // 이력서 경력 목록 조회
    List<Career> resumeCareerList(int rNo);
    // 이력서 인턴,대외활동 목록 조회
    List<Activity> resumeActivityList(int rNo);
    // 이력서 자격증,어학,수상 내역 목록 조회
    List<License> resumeLicenseList(int rNo);
    List<Language> resumeLanguageList(int rNo);
    List<Awards> resumeAwardsList(int rNo);
    // 자소서 목록 조회
    List<SelfIntroduction> resumeSelfIntroductionList(int rNo);

}
