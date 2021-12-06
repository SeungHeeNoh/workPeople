package com.kh.workPeople.account.login.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.login.model.dao.LoginMapper;
import com.kh.workPeople.common.vo.Authority;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.MemberImpl;


@Service
public class MemberLoginServiceImpl implements MemberLoginService {
	
	private LoginMapper loginMapper;
	
	@Autowired
	public MemberLoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	@Override
	public Member findMemberById(String id) {
		return loginMapper.findMemberById(id);
	}

	@Override
	public int updateLoginInformation(MemberImpl userImpl) {
		int result = loginMapper.updateLoginInformation(userImpl);
		return result;
	}

	@Override
	public void updateFailureCount(String id) {
		loginMapper.updateFailureCount(id);
	}

	@Override
	public void updateAccountLock(String id) {
		loginMapper.updateAccountLock(id);
		
	}

}
