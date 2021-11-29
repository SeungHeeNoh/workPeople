package com.kh.workPeople.company.mypage.promotion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.PromotionOrder;
import com.kh.workPeople.company.mypage.promotion.dao.PromotionMapper;

@Service
public class PromotionServiceImpl implements PromotionService{
	
	private PromotionMapper promotionMapper;

	@Autowired
	public PromotionServiceImpl(PromotionMapper promotionMapper) {
		this.promotionMapper = promotionMapper;
	}

	@Override
	public Map<String, Object> findList(int page, int userNo) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> noMap = new HashMap<>();
		
		int listCount = promotionMapper.getListCount(userNo);
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		noMap.put("pi", pi);
		noMap.put("userNo", userNo);
		
		List<PromotionOrder> orderList = promotionMapper.selectList(noMap);
		
		int using = promotionMapper.getUsingCount(userNo);
		
		int complete = promotionMapper.getCompleteCount(userNo);
		
		
		returnMap.put("pi", pi);
		returnMap.put("orderList", orderList);
		returnMap.put("using", using);
		returnMap.put("complete", complete);
		
		return returnMap;
	}
	
	

	

}
