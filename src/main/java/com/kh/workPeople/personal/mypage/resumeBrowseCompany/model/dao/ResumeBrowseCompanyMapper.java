package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.dao;

import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeBrowseCompanyMapper {

    List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no);
}
