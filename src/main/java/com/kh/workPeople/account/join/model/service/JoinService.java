package com.kh.workPeople.account.join.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyInfo;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.Sector;

public interface JoinService {

	int checkRegisterNumber(String registerNumber);

	List<CompanyType> selectCompanyTypeList();

	List<Sector> selectSectorList();

	int checkId(String id);
	
	int join(Member member);
	
	int join(Member member, CompanyInfo companyInfo);
}
