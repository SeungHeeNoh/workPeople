package com.kh.workPeople.account.login.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.UserImpl;
import com.kh.workPeople.manager.model.vo.Manager;

@Mapper
public interface LoginMapper {

	Member findMemberById(String userId);
	
	Manager findManagerById(String username);

	int updateLoginInformation(UserImpl userImpl);

	void updateFailureCount(String id);

	void updateAccountLock(String id);
	
}
