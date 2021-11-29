package com.kh.workPeople.personal.mypage.applyCompany.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.personal.mypage.applyCompany.model.dao.ApplyCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyCompanyServiceImpl implements ApplyCompanyService{

    private final ApplyCompanyMapper applyCompanyMapper;

    @Autowired
    public ApplyCompanyServiceImpl(ApplyCompanyMapper applyCompanyMapper){
        this.applyCompanyMapper = applyCompanyMapper;
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
}
