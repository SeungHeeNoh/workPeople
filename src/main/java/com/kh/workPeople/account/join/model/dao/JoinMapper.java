package com.kh.workPeople.account.join.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInfo;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.Sector;

@Mapper
public interface JoinMapper {

	int checkRegisterNumber(String registerNumber);

	List<CompanyType> selectCompanyTypeList();

	List<Sector> selectSectorList();

	int checkId(String id);

	int insertMember(Member member);

	int insertMemberRole(MemberRole memberRole);
	
	int insertCompanyInfo(CompanyInfo companyInfo);
}
