package com.kh.workPeople.company.mypage.promotion.service;

import java.util.List;
import java.util.Map;

import com.kh.workPeople.common.vo.JobVacancyLookUp;


public interface PromotionService {


	Map<String, Object> findList(int page, int userNo);

	int selectcino(int userNo);

	List<JobVacancyLookUp> selectAllJob(int cino);

	int insertPayment(Map<String, Object> map);

	

	

}
