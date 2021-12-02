package com.kh.workPeople.manager.company.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.PageInfo;



@Mapper
public interface CompanyMapper {

	
	int getListCount();
	  
	List<CompanyInformation> selectList(PageInfo pi);

	CompanyInformation vacancyNo(int no);
	 
	

	
}
