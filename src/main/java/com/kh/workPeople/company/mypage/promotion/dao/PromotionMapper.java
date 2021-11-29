package com.kh.workPeople.company.mypage.promotion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.PromotionOrder;


@Mapper
public interface PromotionMapper {

	int getListCount(int userNo);


	List<PromotionOrder> selectList(Map<String, Object> noMap);


	int getUsingCount(int userNo);


	int getCompleteCount(int userNo);

	

}
