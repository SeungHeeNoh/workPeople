package com.kh.workPeople.company.mypage.talented.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.company.mypage.talented.dao.TalentedMapper;

@Service
public class TalentedServiceImpl implements TalentedService{
	
	private TalentedMapper talentedMapper;

	@Autowired
	public TalentedServiceImpl(TalentedMapper talentedMapper) {
		this.talentedMapper = talentedMapper;
	}

	@Override
	public Map<String, Object> findList(int page, int userNo) {
		Map<String, Object> returnMap = new HashMap<>();
		
		CompanyInformation comInfo = talentedMapper.userSnoNumber(userNo);
		int userSno = comInfo.getSector().getNo();
		
		//int listCount = talentedMapper.getListCount(userNo);
		
		//PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		
		
		
		
		return returnMap;
	}
	

	

	
	

	

}
