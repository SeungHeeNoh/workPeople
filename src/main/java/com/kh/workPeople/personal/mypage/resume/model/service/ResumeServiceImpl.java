package com.kh.workPeople.personal.mypage.resume.model.service;

import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.ResumeDetails;
import com.kh.workPeople.personal.mypage.resume.model.dao.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeMapper resumeMapper;

    @Autowired
    public ResumeServiceImpl(ResumeMapper resumeMapper){
        this.resumeMapper = resumeMapper;
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
}
