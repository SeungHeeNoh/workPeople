package com.kh.workPeople.company.mypage.companyInfo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Attachment;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;

@Mapper
public interface CompanyInfoMapper {

	CompanyInformation companyInfoSelect(int userNo);

	Member memberInfoSelect(String userId);

	int updateMember(Member member);

	int updateCompany(CompanyInformation companyInformation);

	int insertAttachment(Attachment att);

	int updatecompanyAtt(int companyNO);

	int selectAnoCount(int companyNO);

	CompanyInformation selectcompanyAno(int companyNO);

	int updateAttachment(Map<String, Object> map);

	int deleteFile(int no);

	int deletecompanyAtt(int companyNO);

	

}
