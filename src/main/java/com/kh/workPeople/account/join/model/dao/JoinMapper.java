package com.kh.workPeople.account.join.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {

	int checkRegisterNumber(int registerNumber);

}
