package com.kh.workPeople.company.mypage.talented.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;

@Mapper
public interface TalentedMapper {

	CompanyInformation userSnoNumber(int userNo);

	//int getListCount(int userNo);

	

	

}
