package com.kh.workPeople.personal.mypage.applyCompany.model.service;

import com.kh.workPeople.common.vo.*;
import com.kh.workPeople.personal.mypage.applyCompany.model.dao.ApplyCompanyMapper;
import com.kh.workPeople.personal.mypage.home.model.dao.HomeMapper;
import com.kh.workPeople.personal.mypage.resume.model.dao.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplyCompanyServiceImpl implements ApplyCompanyService {

    private final ApplyCompanyMapper applyCompanyMapper;
    private final ResumeMapper resumeMapper;
    private final HomeMapper homeMapper;


    @Autowired
    public ApplyCompanyServiceImpl(HomeMapper homeMapper,ResumeMapper resumeMapper,ApplyCompanyMapper applyCompanyMapper){
        this.applyCompanyMapper = applyCompanyMapper;
        this.resumeMapper = resumeMapper;
        this.homeMapper = homeMapper;
    }

    @Override
    public int applyCount(int no) {
        return applyCompanyMapper.applyCount(no);
    }

    @Override
    public int passCount(int no) {
        return applyCompanyMapper.passCount(no);
    }

    @Override
    public int interviewCount(int no) {
        return applyCompanyMapper.interviewCount(no);
    }

    @Override
    public int passAllCount(int no) {
        return applyCompanyMapper.passAllCount(no);
    }

    @Override
    public int failureCount(int no) {
        return applyCompanyMapper.failureCount(no);
    }

    @Override
    public List<JobVacancyLookUp> jobVacancyLookUpList(int no) {
        return applyCompanyMapper.jobVacancyLookUpList(no);
    }

    @Override
    public int applyCompany(int userNo, int jvNo) {
//        System.out.println("applyCompanyMapper.applyCompany(userNo,jvNo) : " + applyCompanyMapper.applyCompany(userNo,jvNo));
        return applyCompanyMapper.applyCompany(userNo,jvNo);
    }
    @Override
    public int insertAppliedTable(int userNo, int jvNo){
        // 회원의 대표이력서 번호 알아오기
        Resume statusYResume = homeMapper.selectResumeStatusY(userNo);

        if(statusYResume != null) {

            int rNo = statusYResume.getNo();

            // 회원의 입사지원한 구분번호 알아오기
            ApplyCompany applyCompanyNo = applyCompanyMapper.selectApplyCompany(userNo, jvNo);

            if (applyCompanyNo != null) {

                int acNo = applyCompanyNo.getAcNo();

                // 회원 대표이력서의 정보 읽어오기
                ResumeDetails basicInfoAndEducation = resumeMapper.resumeDetailsLookUp(rNo);
                System.out.println("basicInfoAndEducation : "+basicInfoAndEducation);
                List<Career> resumeCareerList = resumeMapper.resumeCareerList(rNo);
                List<Activity> resumeActivityList = resumeMapper.resumeActivityList(rNo);
                List<License> resumeLicenseList = resumeMapper.resumeLicenseList(rNo);
                List<Language> resumeLanguageList = resumeMapper.resumeLanguageList(rNo);
                List<Awards> resumeAwardsList = resumeMapper.resumeAwardsList(rNo);
                List<SelfIntroduction> resumeSelfIntroductionList = resumeMapper.resumeSelfIntroductionList(rNo);


//        각각의 테이블에 입사지원 구분번호 삽입,
                // applied_테이블에 데이터 삽입

                basicInfoAndEducation.setAcNo(acNo);
                int appliedbasicInfo = resumeMapper.appliedbasicInfoAndEducation(basicInfoAndEducation);
                int appliedbasicEducation = resumeMapper.appliedbasicInfoAndEducation2(basicInfoAndEducation);

                for (Career career : resumeCareerList) {
                    career.setAcNo(acNo);
                    int appliedCareer = resumeMapper.appliedappliedCareer(career);
                }
                for (Activity activity : resumeActivityList) {
                    activity.setAcNo(acNo);
                    int appliedActivity = resumeMapper.appliedActivity(activity);
                }
                for (License license : resumeLicenseList) {
                    license.setAcNo(acNo);
                    int appliedLicense = resumeMapper.appliedLicense(license);
                }
                for (Language language : resumeLanguageList) {
                    language.setAcNo(acNo);
                    int appliedLanguage = resumeMapper.appliedLanguage(language);
                }
                for (Awards awards : resumeAwardsList) {
                    awards.setAcNo(acNo);
                    int appliedAwards = resumeMapper.appliedAwards(awards);
                }
                for (SelfIntroduction selfIntroduction : resumeSelfIntroductionList) {
                    selfIntroduction.setAcNo(acNo);
                    int appliedSelfIntroduction = resumeMapper.appliedSelfIntroduction(selfIntroduction);
                }
            }
        }
        return 1;
    }

    @Override
    public int insertNotStatusYAppliedTable(int userNo, int jvNo,int rNo) {


            // 회원의 입사지원한 구분번호 알아오기
            ApplyCompany applyCompanyNo = applyCompanyMapper.selectApplyCompany(userNo, jvNo);

            if (applyCompanyNo != null) {

                int acNo = applyCompanyNo.getAcNo();

                // 선택한 회원 이력서의 정보 읽어오기
                ResumeDetails basicInfoAndEducation = resumeMapper.resumeDetailsLookUp(rNo);
                List<Career> resumeCareerList = resumeMapper.resumeCareerList(rNo);
                List<Activity> resumeActivityList = resumeMapper.resumeActivityList(rNo);
                List<License> resumeLicenseList = resumeMapper.resumeLicenseList(rNo);
                List<Language> resumeLanguageList = resumeMapper.resumeLanguageList(rNo);
                List<Awards> resumeAwardsList = resumeMapper.resumeAwardsList(rNo);
                List<SelfIntroduction> resumeSelfIntroductionList = resumeMapper.resumeSelfIntroductionList(rNo);


//        각각의 테이블에 입사지원 구분번호 삽입,
                // applied_테이블에 데이터 삽입

                basicInfoAndEducation.setAcNo(acNo);
                int appliedbasicInfo = resumeMapper.appliedbasicInfoAndEducation(basicInfoAndEducation);
                int appliedbasicEducation = resumeMapper.appliedbasicInfoAndEducation2(basicInfoAndEducation);

                for (Career career : resumeCareerList) {
                    career.setAcNo(acNo);
                    int appliedCareer = resumeMapper.appliedappliedCareer(career);
                }
                for (Activity activity : resumeActivityList) {
                    activity.setAcNo(acNo);
                    int appliedActivity = resumeMapper.appliedActivity(activity);
                }
                for (License license : resumeLicenseList) {
                    license.setAcNo(acNo);
                    int appliedLicense = resumeMapper.appliedLicense(license);
                }
                for (Language language : resumeLanguageList) {
                    language.setAcNo(acNo);
                    int appliedLanguage = resumeMapper.appliedLanguage(language);
                }
                for (Awards awards : resumeAwardsList) {
                    awards.setAcNo(acNo);
                    int appliedAwards = resumeMapper.appliedAwards(awards);
                }
                for (SelfIntroduction selfIntroduction : resumeSelfIntroductionList) {
                    selfIntroduction.setAcNo(acNo);
                    int appliedSelfIntroduction = resumeMapper.appliedSelfIntroduction(selfIntroduction);
                }

        }
        return 1;







    }

    @Override
    public Map<String, Object> jobVacancyLookUpListPaging(int no, int page) {

        Map<String, Object> returnMap = new HashMap<>();

        int listCount = applyCompanyMapper.jobVacancyLookUpList(no).size();

        PageInfo pi = new PageInfo(page, listCount, 10, 10, no);

        List<JobVacancyLookUp> jobVacancyLookUpList = applyCompanyMapper.jobVacancyLookUpListPagingQuery(pi);

        returnMap.put("pi",pi);
        returnMap.put("jobVacancyLookUpList",jobVacancyLookUpList);

        return returnMap;
    }

    @Override
    public JobVacancyLookUp applyCompanyRbDateFormat(int jvNo) {
        return applyCompanyMapper.applyCompanyRbDateFormat(jvNo);
    }

    @Override
    public int applyCancel(int no, List<Integer> jvNoList) {


        for(Integer i : jvNoList){

            ApplyCompany applyCompany = applyCompanyMapper.selectApplyCompany(no,i);
            int acNo = applyCompany.getAcNo();

            int deleteAppliedBasicInfo = applyCompanyMapper.deleteAppliedBasicInfo(acNo);
            int deleteAppliedEducation = applyCompanyMapper.deleteAppliedEducation(acNo);

            int appliedCareerNum = applyCompanyMapper.appliedCareerNum(acNo);
            int appliedActivityNum = applyCompanyMapper.appliedActivityNum(acNo);
            int appliedLicenseNum = applyCompanyMapper.appliedLicenseNum(acNo);
            int appliedLanguageNum = applyCompanyMapper.appliedLanguageNum(acNo);
            int appliedAwardsNum = applyCompanyMapper.appliedAwardsNum(acNo);
            int appliedSelfIntroduction = applyCompanyMapper.appliedSelfIntroduction(acNo);

            if(appliedCareerNum>0){
                int deleteAppliedCareer = applyCompanyMapper.deleteAppliedCareer(acNo);
            }
            if(appliedActivityNum>0){
                int deleteAppliedActivity = applyCompanyMapper.deleteAppliedActivity(acNo);
            }
            if(appliedLicenseNum>0){
                int deleteAppliedLicense = applyCompanyMapper.deleteAppliedLicense(acNo);
            }
            if(appliedLanguageNum>0){
                int deleteAppliedLanguage = applyCompanyMapper.deleteAppliedLanguage(acNo);
            }
            if(appliedAwardsNum>0){
                int deleteAppliedAwards = applyCompanyMapper.deleteAppliedAwards(acNo);
            }
            if(appliedSelfIntroduction>0){
                int deleteAppliedSelfIntroduction = applyCompanyMapper.deleteAppliedSelfIntroduction(acNo);
            }

            int deleteApplyCompany = applyCompanyMapper.deleteApplyCompany(acNo);

        }

        return 1;
    }


}
