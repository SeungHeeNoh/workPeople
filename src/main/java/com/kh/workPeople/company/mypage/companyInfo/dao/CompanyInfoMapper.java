package com.kh.workPeople.company.mypage.companyInfo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyInfoMapper {

	CompanyInformation companyInfoSelect(int userNo);

	Member memberInfoSelect(String userId);

	int updateMember(Member member);

	int updateCompany(CompanyInformation companyInformation);

	

}
