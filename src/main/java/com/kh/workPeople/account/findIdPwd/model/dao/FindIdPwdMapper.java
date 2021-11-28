package com.kh.workPeople.account.findIdPwd.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;

@Mapper
public interface FindIdPwdMapper {

	Member findMemberForId(Map<String, String> input);

	Member findMemberForPwd(Map<String, String> input);


}
