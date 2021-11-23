package com.kh.workPeople.company.mypage.companyInfo.serivce;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kh.workPeople.common.vo.Member;

public interface CompanyInfoService extends UserDetailsService{

	void companyInfoSelect(Member member);

}
