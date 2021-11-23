package com.kh.workPeople.account.join.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.workPeople.account.join.model.dao.JoinMapper;
import com.kh.workPeople.common.vo.CompanyInfo;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.Sector;

@Service()
public class JoinServiceImpl implements JoinService {
	
	private PasswordEncoder passwordEncoder;
	private JoinMapper joinMapper;

	@Autowired
	public JoinServiceImpl(JoinMapper joinMapper, PasswordEncoder passwordEncoder) {
		this.joinMapper = joinMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public int checkRegisterNumber(String registerNumber) {
		return joinMapper.checkRegisterNumber(registerNumber);
	}

	@Override
	public List<CompanyType> selectCompanyTypeList() {
		return joinMapper.selectCompanyTypeList();
	}

	@Override
	public List<Sector> selectSectorList() {
		return joinMapper.selectSectorList();
	}

	@Override
	public int checkId(String id) {
		return joinMapper.checkId(id);
	}

	@Transactional
	@Override
	public int join(Member member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		MemberRole memberRole = new MemberRole();
		memberRole.setAuthorityCode(1);

		int result1 = joinMapper.insertMember(member);
		int result2 = joinMapper.insertMemberRole(memberRole);
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}
	
	@Transactional
	@Override
	public int join(Member member, CompanyInfo companyInfo) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		MemberRole memberRole = new MemberRole();
		memberRole.setAuthorityCode(2);
		
		int result1 = joinMapper.insertMember(member);
		int result2 = joinMapper.insertMemberRole(memberRole);
		int result3 = joinMapper.insertCompanyInfo(companyInfo);
		
		return (result1 > 0 && result2 > 0 && result3 > 0) ? 1 : 0;
		
	}
}
