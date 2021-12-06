package com.kh.workPeople.account.login.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;

@Mapper
public interface LoginMapper {
	
	Member findMemberByIdAndMemberType(Map<String, Object> queryMap);

	Member findMemberById(String userId);
	
	Manager findManagerById(String username);

	int updateLoginInformation(MemberImpl userImpl);

	void updateFailureCount(String id);

	void updateAccountLock(String id);

	Map<String, Object> findCompanyNo(int no);

	
}
