package com.kh.workPeople.personal.mypage.applyCompany.model.service;

import com.kh.workPeople.common.vo.Career;
import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.personal.mypage.applyCompany.model.dao.ApplyCompanyMapper;
import com.kh.workPeople.personal.mypage.resume.model.dao.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public int applyCompany(int rNo, int applyBtnNo) {
        return applyCompanyMapper.applyCompany(rNo,applyBtnNo);
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
    public int insertappliedBasicInfo(ResumeDetails basicInfoAndEducation) {
        return applyCompanyMapper.insertappliedBasicInfo(basicInfoAndEducation);
    }


}
