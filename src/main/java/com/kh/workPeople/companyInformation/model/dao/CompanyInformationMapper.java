package com.kh.workPeople.companyInformation.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyInformationMapper {
	
	Member getMember(int no);

	CompanyInformation getCompanyInformation(int no);

}
