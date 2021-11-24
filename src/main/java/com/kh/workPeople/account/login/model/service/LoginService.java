package com.kh.workPeople.account.login.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.UserImpl;

public interface LoginService extends UserDetailsService {
	
	int updateLoginInformation(UserImpl userImpl);

	Member findMemberById(String id);

	void updateFailureCount(String id);

	void updateAccountLock(String id);
}
