package com.kh.workPeople.account.login.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;

@Mapper
public interface LoginMapper {

	Member findMemberById(String userId);
}
