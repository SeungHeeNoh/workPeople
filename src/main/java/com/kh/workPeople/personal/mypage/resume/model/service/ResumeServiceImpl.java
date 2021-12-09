package com.kh.workPeople.personal.mypage.resume.model.service;

import com.kh.workPeople.common.vo.*;
import com.kh.workPeople.company.mypage.companyInfo.dao.CompanyInfoMapper;
import com.kh.workPeople.personal.mypage.resume.model.dao.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeMapper resumeMapper;
    private final CompanyInfoMapper companyInfoMapper;

    @Autowired
    public ResumeServiceImpl(ResumeMapper resumeMapper,CompanyInfoMapper companyInfoMapper){
        this.resumeMapper = resumeMapper;
        this.companyInfoMapper=companyInfoMapper;
    }

    @Override
    public List<Resume> resumeList(int no) {

        return resumeMapper.resumeList(no);
    }

    @Override
    public int resumeBrowseCount(int repResumeNo) {
        return resumeMapper.resumeBrowseCount(repResumeNo);
    }

    @Override
    public int applyCompanyCount(int repResumeNo) {
        return resumeMapper.applyCompanyCount(repResumeNo);
    }

    @Override
    public ResumeDetails resumeDetailsLookUp(int rNo) {
        return resumeMapper.resumeDetailsLookUp(rNo);
    }

    @Override
    public ResumeDetails resumeDetailsLookUpFormat(int rNo) {
        return resumeMapper.resumeDetailsLookUpFormat(rNo);
    }

    @Override
    public List<Career> resumeCareerList(int rNo) {
        return resumeMapper.resumeCareerList(rNo);
    }
    @Override
    public List<Activity> resumeActivityList(int rNo) {
        return resumeMapper.resumeActivityList(rNo);
    }

    @Override
    public List<License> resumeLicenseList(int rNo) {
        return resumeMapper.resumeLicenseList(rNo);
    }

    @Override
    public List<Language> resumeLanguageList(int rNo) {
        return resumeMapper.resumeLanguageList(rNo);
    }

    @Override
    public List<Awards> resumeAwardsList(int rNo) {
        return resumeMapper.resumeAwardsList(rNo);
    }

    @Override
    public List<SelfIntroduction> resumeSelfIntroductionList(int rNo) {
        return resumeMapper.resumeSelfIntroductionList(rNo);
    }

    @Override
    public int resumeStatusYtoN(int no) {
        return resumeMapper.resumeStatusYtoN(no);
    }

    @Override
    public int resumeStatusNtoY(int resumeNo) {
        return resumeMapper.resumeStatusNtoY(resumeNo);
    }

    @Override
    public int insertResume(int no) {

        int result = resumeMapper.insertResume(no);



        return resumeMapper.insertResume(no);
    }

    @Override
    public int insertAttachment(Attachment att) {






        return companyInfoMapper.insertAttachment(att);
    }

    @Override
    public int insertBasicInfo(ResumeDetails resumeDetails) {

        int result1 = resumeMapper.insertBasicInfo(resumeDetails);
        int result2 = resumeMapper.insertEducation(resumeDetails);

        System.out.println("result1 : "+result1);
        System.out.println("result2 : "+result2);
        int result = result1 + result2;

        return result == 2 ? 1 : 0;
    }


}
