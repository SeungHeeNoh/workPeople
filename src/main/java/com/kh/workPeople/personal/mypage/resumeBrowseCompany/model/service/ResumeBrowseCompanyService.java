package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service;

import com.kh.workPeople.common.vo.ResumeBrowseCompany;

import java.util.List;

public interface ResumeBrowseCompanyService {

    List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no);
}
