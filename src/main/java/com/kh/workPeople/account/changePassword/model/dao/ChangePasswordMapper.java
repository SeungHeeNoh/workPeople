package com.kh.workPeople.account.changePassword.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;

@Mapper
public interface ChangePasswordMapper {

	int changePassword(Member member);

}
