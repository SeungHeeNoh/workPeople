package com.kh.workPeople.company.mypage.companyInfo.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = companyInfoMapper.findMemberById(username);
		System.out.println(member);
		
		
		
		return null;
	}

	@Override
	public void companyInfoSelect(Member member) {
		// TODO Auto-generated method stub
		
	}

}
