package com.kh.workPeople.company.mypage.companyInfo.serivce;


import com.kh.workPeople.common.vo.Attachment;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;

public interface CompanyInfoService {

	CompanyInformation companyInfoSelect(int userNo);

	Member memberInfoSelect(String userId);

	int info(Member member, CompanyInformation companyInformation);

	int insertAttachment(Attachment att, int companyNO);

	int deleteFile(int companyNO);


}
