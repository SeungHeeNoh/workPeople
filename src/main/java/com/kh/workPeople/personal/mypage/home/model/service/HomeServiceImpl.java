package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.home.model.dao.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;

    @Autowired
    public HomeServiceImpl(HomeMapper homeMapper){
        this.homeMapper = homeMapper;
    }


    @Override
    public Resume selectResumeStatusY(int no) {
        return homeMapper.selectResumeStatusY(no);
    }

    @Override
    public int applyCount(int no) {
        return homeMapper.applyCount(no);
    }

    @Override
    public int resumeBrowseCount(int no) {
        return homeMapper.resumeBrowseCount(no);
    }

    @Override
    public int scrapCount(int no) {
        return homeMapper.scrapCount(no);
    }

    @Override
    public int interestedCompanyCount(int no) {
        return homeMapper.interestedCompanyCount(no);
    }

    @Override
    public int chatCount(int no) {
        return homeMapper.chatCount(no);
    }
    @Override
    public List<JobVacancyLookUp> recommenedJobVacancyList(String elName) {
        return homeMapper.recommenedJobVacancyList(elName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int resumeDelete(int rNo) {
        return homeMapper.resumeDelete(rNo);
    }

    @Override
    public int applyCompanyYN(int no, int jvNo) {
        return homeMapper.applyCompanyYN(no,jvNo);
    }

    @Override
    public int resumeIsApplyCompanyYN(int rNo) {
        return homeMapper.resumeIsApplyCompanyYN(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int resumeDeleteFromDB(int rNo) {
        return homeMapper.resumeDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int basicInfoDeleteFromDB(int rNo) {
        return homeMapper.basicInfoDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int educationDeleteFromDB(int rNo) {
        return homeMapper.educationDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int careerDeleteFromDB(int rNo) {
        return homeMapper.careerDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int activityDeleteFromDB(int rNo) {
        return homeMapper.activityDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int licenseDeleteFromDB(int rNo) {
        return homeMapper.licenseDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int languageDeleteFromDB(int rNo) {
        return homeMapper.languageDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int awardsDeleteFromDB(int rNo) {
        return homeMapper.awardsDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int selfIntroductionDeleteFromDB(int rNo) {
        return homeMapper.selfIntroductionDeleteFromDB(rNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int resumeBrowseDeleteFromDB(int rNo) {
        return homeMapper.resumeBrowseDeleteFromDB(rNo);
    }
}
