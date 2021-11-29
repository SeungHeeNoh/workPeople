package com.kh.workPeople.company.mypage.memberInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.memberInfo.dao.MemberInfoMapper;

@Service
public class MemberInfoServiceImpl implements MemberInfoService{
	
	private MemberInfoMapper memberInfoMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberInfoServiceImpl(MemberInfoMapper memberInfoMapper, PasswordEncoder passwordEncoder) {
		this.memberInfoMapper = memberInfoMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public int updateInfo(Member member) {
		return memberInfoMapper.updateInfo(member);
	}

	@Override
	public int updatePwd(Member member) {
		String securePw = passwordEncoder.encode(member.getPwd());
		member.setPwd(securePw);
		
		return memberInfoMapper.updatePwd(member);
	}

	@Override
	public Member selectAll(Member member) {
		return memberInfoMapper.selectAll(member);
	}


}
