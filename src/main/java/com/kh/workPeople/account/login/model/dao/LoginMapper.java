package com.kh.workPeople.account.login.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.UserImpl;

@Mapper
public interface LoginMapper {

	Member findMemberById(String userId);

	int updateLoginInformation(UserImpl userImpl);
	
}
