package com.kh.workPeople.account.findIdPwd.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FindIdPwdMapper {

	String findPersonalId(Map<String, String> input);

	String findCompanyId(Map<String, String> input);

}
