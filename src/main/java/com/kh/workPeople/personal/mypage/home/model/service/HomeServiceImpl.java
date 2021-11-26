package com.kh.workPeople.personal.mypage.home.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.home.model.dao.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private HomeMapper homeMapper;

    @Autowired
    public HomeServiceImpl(HomeMapper homeMapper){
       this.homeMapper = homeMapper;
    }


    @Override
    public Resume selectResumeStatusY(int no) {
        return homeMapper.selectResumeStatusY(no);
    }

    @Override
    public List<JobVacancyLookUp> recommenedJobVacancyList(String elName) {
        return homeMapper.recommenedJobVacancyList(elName);
    }
}
