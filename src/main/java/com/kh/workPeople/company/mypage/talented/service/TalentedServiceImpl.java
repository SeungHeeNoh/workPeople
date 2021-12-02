package com.kh.workPeople.company.mypage.talented.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.PersonInfoResume;
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
		Map<String, Object> noMap = new HashMap<>();
		
		CompanyInformation comInfo = talentedMapper.userSnoNumber(userNo);
		int userSno = comInfo.getSector().getNo();
		int cino = comInfo.getNo();
		
		int listCount = talentedMapper.getListCount(userSno);
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		noMap.put("pi", pi);
		noMap.put("userSno", userSno);
		noMap.put("cino", cino);
		
		List<PersonInfoResume> personList = talentedMapper.selectList(noMap);
		
		returnMap.put("pi", pi);
		returnMap.put("cino", cino);
		returnMap.put("personList", personList);
		returnMap.put("listCount", listCount);
		
		return returnMap;
	}

	@Override
	public int insertResume(int rno, int cino) {
		return talentedMapper.insertResume(rno, cino);
	}

	@Override
	public int selectResumeCount(int rno, int cino) {
		return talentedMapper.selectResumeCount(rno, cino);
	}
	

	

	
	

	

}
