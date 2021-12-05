package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service;

import com.kh.workPeople.common.vo.ResumeBrowseCompany;

import java.util.List;
import java.util.Map;

public interface ResumeBrowseCompanyService {

    List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no);

    Map<String, Object> selectResumeBrowseCompanyListPaging(int no, int page);

    int deleteResumeBrowseCompanyList(int no, List<Integer> ciNoList);
}
