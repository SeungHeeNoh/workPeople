package com.kh.workPeople.company.mypage.memberInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
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

	@Override
	public int leave(MemberImpl user) {
		
		int result1 = memberInfoMapper.leave(user.getNo());
		
		int cino = memberInfoMapper.selectCompanyNo(user.getNo());
		
		int result2 = memberInfoMapper.leaveJobVacancy(cino);
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}


	// 개인회원 정보 수정
	@Override
	public int updatePersonalInfo(Member member) {
		return memberInfoMapper.updatePersonalInfo(member);
	}


}
