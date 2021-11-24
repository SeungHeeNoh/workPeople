package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service;

import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.dao.ResumeBrowseCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeBrowseCompanyServiceImpl implements ResumeBrowseCompanyService{

    private ResumeBrowseCompanyMapper resumeBrowseCompanyMapper;

    @Autowired
    public ResumeBrowseCompanyServiceImpl(ResumeBrowseCompanyMapper resumeBrowseCompanyMapper){
        this.resumeBrowseCompanyMapper = resumeBrowseCompanyMapper;
    }


    @Override
    public List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no) {
        return resumeBrowseCompanyMapper.selectResumeBrowseCompanyList(no);
    }
}
