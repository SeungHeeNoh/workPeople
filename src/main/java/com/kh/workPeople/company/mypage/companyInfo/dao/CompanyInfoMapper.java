package com.kh.workPeople.company.mypage.companyInfo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyInfoMapper {

	Member findMemberById(String userId);

}
