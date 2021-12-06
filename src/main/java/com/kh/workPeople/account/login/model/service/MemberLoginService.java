package com.kh.workPeople.account.login.model.service;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;

public interface MemberLoginService {
	
	int updateLoginInformation(MemberImpl userImpl);

	Member findMemberById(String id);

	void updateFailureCount(String id);

	void updateAccountLock(String id);
}
