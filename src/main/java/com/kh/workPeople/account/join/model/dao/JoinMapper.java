package com.kh.workPeople.account.join.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Sector;

@Mapper
public interface JoinMapper {

	int checkRegisterNumber(int registerNumber);

	List<CompanyType> selectCompanyTypeList();

	List<Sector> selectSectorList();

	int checkId(String id);
}
