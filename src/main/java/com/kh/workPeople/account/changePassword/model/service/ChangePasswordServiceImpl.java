package com.kh.workPeople.account.changePassword.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.changePassword.model.dao.ChangePasswordMapper;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
	
	private PasswordEncoder passwordEncoder;
	private ChangePasswordMapper changePasswordMapper;
	
	@Autowired
	public ChangePasswordServiceImpl(PasswordEncoder passwordEncoder, ChangePasswordMapper changePasswordMapper) {
		this.passwordEncoder = passwordEncoder;
		this.changePasswordMapper = changePasswordMapper;
	}

	@Override
	public int changePassword(MemberImpl memberImpl, String password) {
		Member member = new Member();
		member.setId(memberImpl.getId());
		member.setPwd(passwordEncoder.encode(password));
		
		return changePasswordMapper.changePassword(member);
	}

}
