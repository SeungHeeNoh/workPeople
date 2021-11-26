package com.kh.workPeople.manager.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.PageInfo;

@Mapper
public interface ManagerMapper {

	int getListCount();

	List<Manager> selectList(PageInfo pi);
	

	
}
