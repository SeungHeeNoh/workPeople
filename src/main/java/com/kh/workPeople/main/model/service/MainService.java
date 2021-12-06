package com.kh.workPeople.main.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.MainTier;

public interface MainService {

	int getJvCount();

	int getSkCount();

	int getCmCount();
	
	List<MainTier> getPlatinumList();
	List<MainTier> getBasicList();
	
}
