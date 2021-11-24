package com.kh.workPeople.company.mypage.companyInfo.serivce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.companyInfo.dao.CompanyInfoMapper;


@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{
	
	private CompanyInfoMapper companyInfoMapper;

	
	@Autowired
	public CompanyInfoServiceImpl(CompanyInfoMapper companyInfoMapper) {
		this.companyInfoMapper = companyInfoMapper;
	}

	@Override
	public Member memberInfoSelect(String userId) {
		return companyInfoMapper.memberInfoSelect(userId);
	}


	@Override
	public CompanyInformation companyInfoSelect(int userNo) {
		return companyInfoMapper.companyInfoSelect(userNo);
	}


	@Override
	public int info(Member member, CompanyInformation companyInformation) {
		int result1 = companyInfoMapper.updateMember(member);
		int result2 = companyInfoMapper.updateCompany(companyInformation);
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}

	

}
