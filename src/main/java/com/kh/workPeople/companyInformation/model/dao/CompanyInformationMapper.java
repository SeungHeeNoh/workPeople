package com.kh.workPeople.companyInformation.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.companyInformation.model.vo.CompanyDetailInformation;

@Mapper
public interface CompanyInformationMapper {

	CompanyDetailInformation getCompanyDetailInformation(int no);

}
