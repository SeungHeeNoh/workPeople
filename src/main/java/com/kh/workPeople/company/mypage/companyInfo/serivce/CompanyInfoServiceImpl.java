package com.kh.workPeople.company.mypage.companyInfo.serivce;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Attachment;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.companyInfo.dao.CompanyInfoMapper;


@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{
	
	private CompanyInfoMapper companyInfoMapper;

	
	@Autowired
	public CompanyInfoServiceImpl(CompanyInfoMapper companyInfoMapper) {
		this.companyInfoMapper = companyInfoMapper;
	}

	@Override
	public Member memberInfoSelect(String userId) {
		return companyInfoMapper.memberInfoSelect(userId);
	}


	@Override
	public CompanyInformation companyInfoSelect(int userNo) {
		return companyInfoMapper.companyInfoSelect(userNo);
	}


	@Override
	public int info(Member member, CompanyInformation companyInformation) {
		int result1 = companyInfoMapper.updateMember(member);
		int result2 = companyInfoMapper.updateCompany(companyInformation);
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}

	@Override
	public int insertAttachment(Attachment att, int companyNO) {
		
		Map<String, Object> map = new HashMap<>();
		
		int cut = companyInfoMapper.selectAnoCount(companyNO);
		CompanyInformation com = companyInfoMapper.selectcompanyAno(companyNO);
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		if (cut == 0) {
			result1 = companyInfoMapper.insertAttachment(att);
			result2 = companyInfoMapper.updatecompanyAtt(companyNO);
			
		} else {
			int ano = com.getAttachment().getNo();
			map.put("ano", ano);
			map.put("att", att);
			result3 = companyInfoMapper.updateAttachment(map);
		}
	
		return (result1 > 0 && result2 > 0 || result3 > 0) ? 1 : 0;
	}

	@Override
	public int deleteFile(int companyNO) {
		
		CompanyInformation com = companyInfoMapper.selectcompanyAno(companyNO);
		int no = com.getAttachment().getNo();
		
		int result1 = companyInfoMapper.deletecompanyAtt(companyNO);
		int result2 = companyInfoMapper.deleteFile(no);
		
		
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}

	

}
