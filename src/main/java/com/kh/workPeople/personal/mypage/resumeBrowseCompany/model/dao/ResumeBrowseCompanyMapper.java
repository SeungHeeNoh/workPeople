package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.dao;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResumeBrowseCompanyMapper {

    List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no);

    List<ResumeBrowseCompany> selectResumeBrowseCompanyListPagingQuery(PageInfo pi);


    int deleteResumeBrowseCompanyListMap(Map<String, Integer> deleteMap);
}
