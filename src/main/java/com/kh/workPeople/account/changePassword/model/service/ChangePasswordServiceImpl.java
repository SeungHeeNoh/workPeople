package com.kh.workPeople.account.changePassword.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.changePassword.model.dao.ChangePasswordMapper;
import com.kh.workPeople.account.login.model.dao.LoginMapper;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
	
	private PasswordEncoder passwordEncoder;
	private LoginMapper loginMapper;
	private ChangePasswordMapper changePasswordMapper;
	
	@Autowired
	public ChangePasswordServiceImpl(PasswordEncoder passwordEncoder, LoginMapper loginMapper, ChangePasswordMapper changePasswordMapper) {
		this.passwordEncoder = passwordEncoder;
		this.loginMapper = loginMapper;
		this.changePasswordMapper = changePasswordMapper;
	}

	@Override
	public int changePassword(MemberImpl memberImpl, String password) {
		int result = 0;
		Member member = new Member();
		member.setId(memberImpl.getId());
		member.setPwd(passwordEncoder.encode(password));
		
		result = changePasswordMapper.changePassword(member);
		
		if(result > 0) {
			Member updateMember = loginMapper.findMemberById(memberImpl.getId());
			memberImpl.setDetails(updateMember);
		}
		
		return result; 
	}

}
