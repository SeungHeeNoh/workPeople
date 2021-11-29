package com.kh.workPeople.manager.user.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.PageInfo;

@Mapper
public interface UserMapper {


	int getListCount();

	List<Member> selectList(PageInfo pi);

	
	

	
}
