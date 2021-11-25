package com.kh.workPeople.manager.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.manager.model.dao.ManagerMapper;

@Service
public class ManagerServiceImpl implements ManagerService{
	private ManagerMapper managerMapper;
	
	@Autowired
	public ManagerServiceImpl(ManagerMapper ManagerMapper) {
		this.managerMapper = ManagerMapper;
	}

	@Override
	public Map<String, Object> mlist(int page) {
		Map<String, Object> returnMap = new HashMap<>();
		int listCount = managerMapper.getListCount();
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		List<Manager> managerList = managerMapper.selectList(pi);
		
		returnMap.put("pi", pi);
		returnMap.put("managerList", managerList);
		
		return returnMap;
	}
	
	
}
