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
}
